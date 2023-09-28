package ATM;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ATM {

	
	private static Map<Integer,User> users;
	private static Map<Integer,Account> accounts;
	private static int loggedInUserId;
	private static Scanner scan;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		users=new HashMap<>();
		accounts =new HashMap<>();
		loggedInUserId=-1;
		scan=new Scanner(System.in);
		
		//Initialize users and accounts
		intializeaUsersAndAccounts();
		
		while(true)
		{
			if(loggedInUserId==-1) {
				System.out.println("Welcome to my ATM");
				System.out.println("Enter your ID:");
				int userId=scan.nextInt();
				System.out.println("Enter your PIN:");
				int pin=scan.nextInt();
				
				if(authenticateUser(userId,pin)) {
					loggedInUserId=userId;
					System.out.println("Authentication is successfull");
				}
				else {
					System.out.println("Authentication failed.Please try again.");
				}
			}
			else {
				displayMainMenu();
				int choice=scan.nextInt();
				performMainAction(choice);
			}
		}
	}


	private static void performMainAction(int choice) {
		// TODO Auto-generated method stub
		Account userAccount=accounts.get(loggedInUserId);
		switch(choice) {
		case 1:
			System.out.println("Balance:"+userAccount.getBalance());
			break;
		case 2:
			System.out.println("Enter the amount to be deposited:");
			double depositAmount=scan.nextDouble();
			Deposit.makeDeposit(userAccount,depositAmount);
			
			break;
		case 3:
			System.out.println("Enter the amount to be withdrawn:");
			double withdrawAmount=scan.nextDouble();
			if(Withdraw.makeWithdraw(userAccount,withdrawAmount)) {
				System.out.println("withdraw "+withdrawAmount);
			}
			else {
				System.out.println("Insufficient funds");
			}
			break;
		case 4:
			System.out.println("Enter the recipients Account Number:");
			int recipientAccountNumber=scan.nextInt();
			Account recipientAccount=accounts.get(recipientAccountNumber);
			if(recipientAccount !=null && recipientAccount.isRecipient()) {
				System.out.println("Enter the amount to transfer:");
				double transferAmount=scan.nextDouble();
				if(makeTransfer(userAccount,recipientAccount,transferAmount)) {
					System.out.println("Transferred:"+transferAmount+" to Account Number"+recipientAccountNumber);
				}
				else {
					System.out.println("Transfer failed due to insufficient funds.");
				}
			}
			else {
				System.out.println("Recipient Account Number not found.");
			}
			break;
		case 5:
			displayTransactionHistory(userAccount);
			break;
		case 6:
			quit();
			break;
		}
		
	}
	public static void quit() {
		System.out.println("Thank you for your service!");
		System.exit(0);
	}
	public static boolean makeTransfer(Account sourceAccount, Account destinationAccount, double amount) {
		if(sourceAccount.withdraw(amount)) {
			destinationAccount.deposit(amount);
			Transaction transaction=new Transaction("Transfer",amount ,sourceAccount.getUser());
			transaction.setSourceAccount(sourceAccount);
			transaction.setDestinationAccount(destinationAccount);
			((TransactionHistory) sourceAccount.getTransactionHistory()).addTransaction(transaction);
			((TransactionHistory) destinationAccount.getTransactionHistory()).addTransaction(transaction);
			return true;
		}
		return false;
	}

	private static void displayTransactionHistory(Account account) {
		// TODO Auto-generated method stub
		System.out.println("Transaction Hisotry of "+account.getAccountNumber()+":");
		List<Transaction> transactions=( account.getTransactionHistory()).getTransactionHistory();
		if(transactions.isEmpty()) {
			System.out.println("No transaction available.");
		}
		else {
			SimpleDateFormat dateTime=new SimpleDateFormat("yyyy-mm-dd  hh:mm:ss");
			for(Transaction transaction:transactions) {
				String sourceInfo=transaction.getSourceAccount()!=null?
						"From Account Number "+ transaction.getSourceAccount().getAccountNumber():
							"Self";
				String destinationInfo=transaction.getDestinationAccount()!=null?
						"To Account Number "+ transaction.getDestinationAccount().getAccountNumber():
							"Self";
				System.out.println("Type:" +transaction.getTransactionType() +
						", Account:"+transaction.getAmount()+
						", Source:" +sourceInfo+
						", Destination: "+destinationInfo +
						", Timestamp:"+dateTime.format(transaction.getTimeStamp()));
			}
		}
		
	}


	private static void displayMainMenu() {
		// TODO Auto-generated method stub
		System.out.println("Enter the options to be performed:");
		System.out.println("1.Check Balance");
		System.out.println("2.Deposit");
		System.out.println("3.Withdraw");
		System.out.println("4.Transfer");
		System.out.println("5.Transaction History");
		System.out.println("6.Quit");
		
		
		
	}


	private static boolean authenticateUser(int userId, int pin) {
		if(users.containsKey(userId)) {
			User user=users.get(userId);
			if(user.getPin()==pin) {
				return true;
			}
		}
		return false;
	}


	private static void intializeaUsersAndAccounts() {
		// TODO Auto-generated method stub
		//users information
		User us1=new User(1,"Gangadhar",4321);
		User us2=new User(2,"Ganga",8765);
		users.put(us1.getUserId(),us1);
		users.put(us2.getUserId(),us2);
		
		//accounts information
		Account acc1=new Account(1,10000.0,false);
		Account acc2=new Account(2,20000.0,false);
		acc1.setUser(us1);
		acc2.setUser(us2);
		accounts.put(acc1.getAccountNumber(),acc1);
		accounts.put(acc1.getAccountNumber(),acc1);
		
		//recipients accounts
		Account account1 = new Account(3,1000.0,true);
		Account account2 = new Account(4,2000.0,true);
		Account account3 = new Account(5,3000.0,true);
		accounts.put(account1.getAccountNumber(), account1);
		accounts.put(account2.getAccountNumber(), account2);
		accounts.put(account3.getAccountNumber(), account3);
		
	
	}

}



