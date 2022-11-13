package object.oriented.programs;

public class AccountTest {

	public static void main(String[] args) {
		Account myAccount = new Account();
		
		double accountBal = 20000.0;
		myAccount.setAccBalance(accountBal);
		
		System.out.print("Enter Amount Value: ");
		double amount = new java.util.Scanner(System.in).nextDouble();
		myAccount.debit(amount);
		
		System.out.println("\nRemaining Balance: " + myAccount.getAccBalance());
	}

}
