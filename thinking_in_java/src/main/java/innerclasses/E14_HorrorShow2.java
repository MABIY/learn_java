package innerclasses;


import static org.greggordon.tools.Print.println;

interface Monster{
    void menace();
}

interface DangerousMonster extends Monster {
    void destroy();
}

interface Lethal{
    void kill();
}

class DragonZilla implements DangerousMonster {
    @Override
    public void menace() {

    }

    @Override
    public void destroy() {

    }
}

interface Vampire extends DangerousMonster, Lethal {
    void drinkBlood();
}

class VeryBadVampire implements Vampire{
    @Override
    public void menace() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void kill() {

    }

    @Override
    public void drinkBlood() {

    }
}

public class E14_HorrorShow2 {
    static void u(Monster b) {
        b.menace();
    }

    static void v(DangerousMonster d) {
        d.menace();
        d.destroy();
    }

    static void w(Lethal l) {
        l.kill();
    }

    public DangerousMonster monsterMaker() {
        return new DangerousMonster() {
            @Override
            public void destroy() {
                println("DangerousMonster destroy");
            }

            @Override
            public void menace() {
                println("DangerousMonster menace");
            }
        };
    }

    public Vampire vampireMaker() {
        return new Vampire() {
            @Override
            public void drinkBlood() {
                println("Vampire DrinkBlood");
            }

            @Override
            public void destroy() {
                println("Vampire Destroy");
            }

            @Override
            public void kill() {
                println("Vampire kill");
            }

            @Override
            public void menace() {
                println("Vampire Menace");
            }
        };
    }

    public static void main(String[] args) {
        E14_HorrorShow2 show = new E14_HorrorShow2();
        show.u(show.monsterMaker());
        show.v(show.monsterMaker());
        show.u(show.vampireMaker());
        show.v(show.vampireMaker());
        show.w(show.vampireMaker());
    }
}
