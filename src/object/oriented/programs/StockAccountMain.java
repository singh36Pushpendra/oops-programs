package object.oriented.programs;

public class StockAccountMain {

	public static void main(String[] args) {
		StockAccount account = new StockAccount("mystocks.txt");
		account.printReport();

		account.buy(600, "INFY");
		account.printReport();
		
		account.sell(34000, "GOLD");
		account.printReport();
		
		account.save("piku_stock.txt");
	}

}
