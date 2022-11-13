package object.oriented.programs;

public class Stock {

	private String shareName;
	private double sharePrice;
	private int noOfShare;
	private static int serialNo;
		
	public Stock(String shareName, double sharePrice, int noOfShare) {
	
		this.shareName = shareName;
		this.sharePrice = sharePrice;
		this.noOfShare = noOfShare;
	}

	public void setNoOfShare(int noOfShare) {
		this.noOfShare = noOfShare;
	}


	public static void setSerialNo(int serialNo) {
		Stock.serialNo = serialNo;
	}


	public String getShareName() {
		return shareName;
	}


	public double getSharePrice() {
		return sharePrice;
	}


	public int getNoOfShare() {
		return noOfShare;
	}

	public double getStockValue() {
		return sharePrice * noOfShare;
	}
	
	public String toString() {
		serialNo++;
		return serialNo + "\t" + shareName + "\t\t" + sharePrice + "\t\t" + noOfShare + "\t\t";
	}
	
}
