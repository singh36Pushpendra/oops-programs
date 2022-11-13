package object.oriented.programs;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class StockPortfolio {

	private static Scanner scanner = new Scanner(System.in);
	private static String stockName;
	private static double sharePrice;
	private static int noOfShare, stockCount;

	private static void inputStockDetail() {
		stockCount++;
		System.out.println("\nEnter stock " + stockCount + " details:");
		System.out.print("Enter stock's name: ");
		stockName = scanner.next();
		System.out.print("Enter stock's share price: ");
		sharePrice = scanner.nextDouble();
		System.out.print("Enter stock's number of share: ");
		noOfShare = scanner.nextInt();
	}

	public static void main(String[] args) {
		System.out.print("Enter total number of stocks: ");
		int stocksSize = scanner.nextInt();
		ArrayList<Stock> stocks = new ArrayList<>(stocksSize);
		double stockValue = 0.0, totalValue = 0.0;

		try (PrintWriter out = new PrintWriter("mystocks.txt")) {

			for (int i = 0; i < stocksSize; i++) {
				inputStockDetail();
				stocks.add(new Stock(stockName, sharePrice, noOfShare));

				out.println(stockName + " " + sharePrice + " " + noOfShare);
			}
			System.out.println("Data Saved Successfully to file!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("\nSNO\tSTOCK NAME\tSHARE PRICE\tNO OF SHARE\tSTOCK VALUE");
		System.out.println("--------------------------------------------------------------------------");
		for (Stock stock : stocks) {
			stockValue = stock.getStockValue();
			System.out.println(stock + "" + stockValue);
			totalValue += stockValue;
		}

		System.out.println("--------------------------------------------------------------------------");
		System.out.println("Total Money Invest: " + totalValue);
	}
}
