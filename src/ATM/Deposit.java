package ATM;

public class Deposit {
	public static void makeDeposit(Account account, double amount) {
		account.deposit(amount);
		Transaction transaction=new Transaction("Deposit",amount,account.getUser());
		account.getTransactionHistory().addTransaction(transaction);
		System.out.println(amount+" is successfully Deposited");
	}
}
