package strings;

/**
 * @author: liuHua
 * @create: 2018-11-21 10:31
 **/

public class DatabaseException extends Exception{
	public DatabaseException(int transactionId, int queryID, String message) {
		super(String.format("(t%d, q%d) %s", transactionId, queryID, message));
	}
	
	public static void main(String[] args) {
		try {
			throw new DatabaseException(3, 7, "Write failed");
		} catch (DatabaseException e) {
			System.out.println(e);
		}
	}
}
