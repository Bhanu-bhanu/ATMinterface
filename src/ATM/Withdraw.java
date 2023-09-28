package ATM;

public class Withdraw {
	public static boolean makeWithdraw(Account account,double amount) {
		if(account.withdraw(amount)) {
			Transaction transaction=new Transaction("Withdraw",amount,account.getUser());
			account.getTransactionHistory().addTransaction(transaction);
			return true;
		}
		return false;
	}
}
