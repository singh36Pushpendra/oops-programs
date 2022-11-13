package object.oriented.programs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class StockAccount {

	private ArrayList<Stock> stocks;
	private double accBalance;
	private ArrayList<CompanyShares> companyShares;

	StockAccount(String filename) {

		stocks = new ArrayList<Stock>();
		companyShares = new ArrayList<CompanyShares>();
		companyShares.add(new CompanyShares("GOLD", 250));
		companyShares.add(new CompanyShares("TITAN", 400));
		companyShares.add(new CompanyShares("INFY", 700));
		// Initializing Account Balance.
		accBalance = 1.7e5;
		String[] stockDetails;
		try (BufferedReader reader = new BufferedReader(new FileReader("mystocks.txt"))) {
			String line = reader.readLine();

			while (line != null) {
				stockDetails = line.split(" ");
				stocks.add(new Stock(stockDetails[0], Double.parseDouble(stockDetails[1]),
						Integer.parseInt(stockDetails[2])));

				line = reader.readLine();
			}
		} catch (IOException exc) {
			exc.printStackTrace();
		}
	}

	double valueOf() {
		// Assuming money coming from acc server.
		return accBalance;
	}

	void buy(int amount, String symbol) {

		for (CompanyShares shares : companyShares)
			if (shares.getStockSymbol().equals(symbol))
				for (Stock stock : stocks) {
					if (stock.getShareName().equals(symbol)) {
						int oldShares = stock.getNoOfShare();
						int newShares = (int) (amount / stock.getSharePrice());
						int totalNoOfShares = oldShares + newShares;
						stock.setNoOfShare(totalNoOfShares);
						accBalance -= amount;
						int oldNoOfShares = shares.getNoOfShares();
						oldNoOfShares -= newShares;
						shares.setNoOfShares(oldNoOfShares);
						shares.getDatesAndTimes().add(LocalDateTime.now());
						break;
					}
				}
	}

	void sell(int amount, String symbol) {

		for (CompanyShares shares : companyShares)
			if (shares.getStockSymbol().equals(symbol))
				for (Stock stock : stocks) {
					if (stock.getShareName().equals(symbol)) {
						int oldShares = stock.getNoOfShare();
						int newShares = (int) (amount / stock.getSharePrice());
						int totalNoOfShares = oldShares - newShares;
						stock.setNoOfShare(totalNoOfShares);
						accBalance += amount;
						int oldNoOfShares = shares.getNoOfShares();
						oldNoOfShares += newShares;
						shares.setNoOfShares(oldNoOfShares);
						shares.getDatesAndTimes().add(LocalDateTime.now());
						break;
					}
				}
	}

	void save(String filename) {

		try (PrintWriter writer = new PrintWriter(filename)) {
			for (Stock stock : stocks)
				writer.println(stock.getShareName() + " " + stock.getSharePrice() + " " + stock.getNoOfShare());
			System.out.println("Data Saved Successfully to " + filename + " file!");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	void printReport() {
		double totalValue = 0, stockValue;
		System.out.println("\nSNO\tSTOCK NAME\tSHARE PRICE\tNO OF SHARE\tSTOCK VALUE");
		System.out.println("--------------------------------------------------------------------------");
		for (Stock stock : stocks) {
			stockValue = stock.getStockValue();
			System.out.println(stock + "" + stockValue);
			totalValue += stockValue;
		}

		System.out.println("--------------------------------------------------------------------------");
		System.out.println("Total Money Invest: " + totalValue);
		System.out.println("Total Account Balance: " + accBalance);
	}
}
