package object.oriented.programs;

public class Account {

	private double accBalance;
	
	void setAccBalance(double accBalance) {
		this.accBalance = accBalance;
	}
	
	double getAccBalance() {
		return accBalance;
	}
	
	void debit(double amount) {
		if (amount < accBalance) {
			accBalance -= amount;
			System.out.println("Cash dispense!");
		}
		else
			System.out.println("Insufficient funds: Can't perform debit!");
	}
}
