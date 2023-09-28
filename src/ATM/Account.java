package ATM;

import java.util.ArrayList;
import java.util.List;

public class Account {
	private int accountNumber;
	private double balance;
	private TransactionHistory transactionHistory;
	private User user;
	private boolean isRecipient;
	
	public Account(int accountNumber, double balance, boolean isRecipient) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.isRecipient = isRecipient;
		this.transactionHistory = new TransactionHistory();
		this.user=null;
	}

	public Account(int accountNumber, double balance) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.transactionHistory = new TransactionHistory();
	}
	public boolean isRecipient() {
		return isRecipient;
	}
	
	public double getBalance() {
		return balance;
	}
	public User getUser() {
		return user;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public TransactionHistory getTransactionHistory() {
		return transactionHistory;
	}
	public void deposit(double amount) {
		balance +=amount;
	}
	
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	

	public boolean withdraw(double amount) {
		if(balance >=amount) {
			balance -=amount;
			return true;
		}
		return false;
	}
	public void transfer(Account recipient, double amount) {
		if(withdraw(amount)) {
			recipient.deposit(amount);
		}
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	
}
