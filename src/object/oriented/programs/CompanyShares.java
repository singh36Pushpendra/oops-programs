package object.oriented.programs;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class CompanyShares {

	private String stockSymbol;
	private int noOfShares;
	private ArrayList<LocalDateTime> datesAndTimes;
	
	public CompanyShares(String stockSymbol, int noOfShares) {
		super();
		this.stockSymbol = stockSymbol;
		this.noOfShares = noOfShares;
		datesAndTimes = new ArrayList<LocalDateTime>();
		
	}

	public String getStockSymbol() {
		return stockSymbol;
	}

	public int getNoOfShares() {
		return noOfShares;
	}

	public void setNoOfShares(int noOfShares) {
		this.noOfShares = noOfShares;
	}

	public ArrayList<LocalDateTime> getDatesAndTimes() {
		return datesAndTimes;
	}
	
}
