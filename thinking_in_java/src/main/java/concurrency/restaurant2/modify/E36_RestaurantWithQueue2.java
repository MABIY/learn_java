package concurrency.restaurant2.modify;

import enumerated.menu.Course;
import enumerated.menu.Food;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.*;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

/**
 * @author lh
 * {Args:5}
 * **************************************************
 * Modify RestaurantWithQueues.java so there's one
 * OrderTicket object per table, change order to
 * orderTicket, and add a Table class, with multiple
 * Customers per table.
 * **************************************************
 */

// This is consisted of many orders, and there's one ticket
// per table:
class OrderTicket {
    private static int counter;
    private final int id = counter++;
    private final Table table;
    private final List<Order> orders = Collections.synchronizedList(new LinkedList<>());

    public OrderTicket(Table table) {
        this.table = table;
    }

    public WaitPerson getWaitPerson() {
        return table.getWaitPerson();
    }

    public void placeOrder(Customer customer, Food food) {
        Order order = new Order(customer, food);
        order.setOrderTicket(this);
        orders.add(order);
    }

    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Order Ticket: " + id + " for: " + table + "\n");
        synchronized (orders) {
            for (Order order : orders) {
                sb.append(order.toString() + "\n");
            }
        }
        // Prune  away the last added 'new-line' character
        return sb.substring(0, sb.length() - 1);
    }
}

class Table implements Runnable {
    private static int counter;
    private final int id = counter++;
    private final WaitPerson waitPerson;
    private final List<Customer> customers;
    private final OrderTicket orderTicket = new OrderTicket(this);
    private final CyclicBarrier barrier;
    private final int nCustomers;
    private final ExecutorService exec;

    public Table(WaitPerson waitPerson, int nCustomers, ExecutorService exec) {
        this.waitPerson = waitPerson;
        customers = Collections.synchronizedList(
                new LinkedList<>()
        );
        this.nCustomers = nCustomers;
        this.exec = exec;
        barrier = new CyclicBarrier(nCustomers + 1, new Runnable() {
            @Override
            public void run() {
                print(orderTicket.toString());
            }
        });
    }

    public WaitPerson getWaitPerson() {
        return waitPerson;
    }

    public void placeOrder(Customer cust, Food food) {
        orderTicket.placeOrder(cust, food);
    }

    @Override
    public void run() {
        Customer customer;
        for (int i = 0; i < nCustomers; i++) {
            customers.add(customer = new Customer(barrier,this));
            exec.execute(customer);
        }
        try {
            barrier.await();
        } catch (InterruptedException e) {
            print(this + " intrerrupted");
            return;
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
        waitPerson.placeOrderTicket(orderTicket);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(
                "Table: " + id + " Served by: " + waitPerson + "\n"
        );
        synchronized (customers) {
            for (Customer customer : customers) {
                sb.append(customer.toString() + "\n");
            }
        }
        return sb.substring(0, sb.length() - 1).toString();
    }
}

// This is part of an order ticket(given to the chef)
class Order {
    private static int counter;
    private final int id;
    private final Customer customer;
    private volatile OrderTicket orderTicket;
    private final Food food;

    public Order(Customer customer, Food food) {
        this.customer = customer;
        this.food = food;
        synchronized (Order.class) {
            id = counter++;
        }
    }

    public void setOrderTicket(OrderTicket orderTicket) {
        this.orderTicket = orderTicket;
    }

    public OrderTicket getOrderTicket() {
        return orderTicket;
    }

    public Food item() {
        return food;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public String toString() {
        return "Order: " + id + " item: " + food + " for: " + customer;
    }
}

// This is what comes back from the chef:
class Plate {
    private final Order order;
    private final Food food;

    public Plate(Order order, Food food) {
        this.order = order;
        this.food = food;
    }

    public Order getOrder() {
        return order;
    }

    public Food getFood() {
        return food;
    }

    @Override
    public String toString() {
        return food.toString();
    }
}

class Customer implements Runnable {
    private static int counter;
    private final int id;
    private final CyclicBarrier barrier;
    private final Table table;
    // Only one curso at a time can be received:
    private final SynchronousQueue<Plate> placeSetting = new SynchronousQueue<>();
    private int nPlates; //Number of plates ordered

    public Customer(CyclicBarrier barrier, Table table) {
        this.barrier = barrier;
        this.table = table;
        synchronized (Customer.class) {
            id = counter++;
        }
    }

    public void deliver(Plate p) throws InterruptedException {
        // Only blocks if customer is still
        // eating the previous course
        placeSetting.put(p);
    }

    @Override
    public void run() {
        // First place an order:
        for (Course course : Course.values()) {
            Food food = course.randomSelection();
            table.placeOrder(this, food);
            ++nPlates;
        }
        try {
            barrier.await();
        } catch (InterruptedException e) {
            print(this + " interrupted while ordering meal");
            return;
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
        // Now wait for each ordered plate:
        for (int i = 0; i < nPlates; i++) {
            try {
                // Blocks until course has been delivered:
                print(this + "eating " + placeSetting.take());
            } catch (InterruptedException e) {
                print(this + "waiting for meal interrupted");
                return;
            }
        }
        print(this + "finished meal, leaving");
    }

    @Override
    public String toString() {
        return "Customer " + id + " ";
    }
}

class WaitPerson implements Runnable {
    private static int counter;
    final BlockingQueue<Plate> filledOrders = new LinkedBlockingQueue<>();
    private final int id = counter++;
    private final Restaurant restaurant;

    public WaitPerson(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void placeOrderTicket(OrderTicket orderTicket) {
        try {
            // Shouldn't actually block because this is
            // a LinkedBLockingQueue with no size limit:
            restaurant.orderTickets.put(orderTicket);
        } catch (InterruptedException e) {
            print(this + " placeOrderTicket interupted");
        }
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                // Blocks until a course is ready
                Plate plate = filledOrders.take();
                print(this + "received " + plate + " delivering to " + plate.getOrder().getCustomer());
                plate.getOrder().getCustomer().deliver(plate);
            }
        } catch (InterruptedException e) {
            print(this + " interrupted");
        }
    }

    @Override
    public String toString() {
        return "WaitPerson " + id + " ";
    }
}

class Chef implements Runnable {
    private static int counter;
    private static Random rand = new Random(47);
    private final int id = counter++;
    private final Restaurant restaurant;

    public Chef(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                //Blocks until an order ticket appears:
                OrderTicket orderTicket = restaurant.orderTickets.take();
                List<Order> orders = orderTicket.getOrders();
                synchronized (orders) {
                    for (Order order : orders) {
                        Food requestedItem = order.item();
                        // Time to prepare order:
                        TimeUnit.MILLISECONDS.sleep(rand.nextInt(500));
                        Plate plate = new Plate(order, requestedItem);
                        order.getOrderTicket().getWaitPerson().filledOrders.put(plate);

                    }
                }
            }
        } catch (InterruptedException e) {
            print(this + " interrupted");
        }
        print(this + " off duty");

    }

    @Override
    public String toString() {
        return "Chef " + id + " ";
    }
}

class Restaurant implements Runnable {
    private List<WaitPerson> waitPersons = new ArrayList<>();
    private List<Chef> chefs = new ArrayList<>();
    private ExecutorService exec;
    private static Random rand = new Random(47);
    final BlockingQueue<OrderTicket> orderTickets = new LinkedBlockingQueue<>();

    public Restaurant(ExecutorService exec, int nWaitPersons, int nChefs) {
        this.exec = exec;
        for (int i = 0; i < nWaitPersons; i++) {
            WaitPerson waitPerson = new WaitPerson(this);
            waitPersons.add(waitPerson);
            exec.execute(waitPerson);
        }
        for (int i = 0; i < nChefs; i++) {
            Chef chef = new Chef(this);
            chefs.add(chef);
            exec.execute(chef);
        }
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                // A new group of customers arrive; assign a
                // WaitPerson:
                WaitPerson wp = waitPersons.get(rand.nextInt(waitPersons.size()));
                int nCustomers = rand.nextInt(4) + 1;
                Table t = new Table(wp, nCustomers, exec);
                exec.execute(t);
                TimeUnit.MILLISECONDS.sleep(400 * nCustomers);
            }
        } catch (InterruptedException e) {
            print("Restaurant interrupted");
        }
        print("Restaurant closing");
    }
}

public class E36_RestaurantWithQueue2 {
    public static void main(String[] args) throws InterruptedException, IOException {
        ExecutorService exec = Executors.newCachedThreadPool();
        Restaurant restaurant = new Restaurant(exec, 5, 2);
        exec.execute(restaurant);
        if (args.length > 0) { // Optional argument
            TimeUnit.SECONDS.sleep(new Integer(args[0]));
        } else {
            print("Pree 'ENTER' to quit");
            System.in.read();
        }
        exec.shutdownNow();
    }
}
