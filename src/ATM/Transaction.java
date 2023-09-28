package ATM;

import java.util.Date;

public class Transaction {
	private String transactionType;
	private double amount;
	private User user;
	private Account sourceAccount;
	private Account destinationAccount;
	private Date timeStamp;
	public Transaction(String transactionType, double amount, User user) {
		super();
		this.transactionType = transactionType;
		this.amount = amount;
		this.user = user;
		this.timeStamp=new Date();
		
	}
	public Transaction(String transactionType, double amount, Account sourceAccount, Account destinationAccount) {
		super();
		this.transactionType = transactionType;
		this.amount = amount;
		this.sourceAccount = sourceAccount;
		this.destinationAccount = destinationAccount;
		this.timeStamp=new Date();
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setSourceAccount(Account sourceAccount) {
		this.sourceAccount = sourceAccount;
	}
	public void setDestinationAccount(Account destinationAccount) {
		this.destinationAccount = destinationAccount;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public double getAmount() {
		return amount;
	}
	public User getUser() {
		return user;
	}
	public Account getSourceAccount() {
		return sourceAccount;
	}
	public Account getDestinationAccount() {
		return destinationAccount;
	}
	
	
}
