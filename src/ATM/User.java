package ATM;

public class User {
	private int userId;
	private String name;
	private int pin;
	private TransactionHistory transactionHistory;
	public User(int userId, String name, int pin) {
		super();
		this.userId = userId;
		this.name = name;
		this.pin = pin;
		this.transactionHistory = transactionHistory;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public void setTransactionHistory(TransactionHistory transactionHistory) {
		this.transactionHistory = transactionHistory;
	}
	public int getUserId() {
		return userId;
	}
	
	public int getPin() {
		return pin;
	}
	public TransactionHistory getTransactionHistory() {
		return transactionHistory;
	}
	
}
