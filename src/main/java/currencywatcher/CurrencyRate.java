package currencywatcher;

public class CurrencyRate {
	
	private String currencyType;
	private double maxPrice;
	private double minPrice;
	private double avgPrice;
	private double curPrice;
	
	public CurrencyRate() {}
	public CurrencyRate(String currencyType, double maxPrice, double minPrice, double avgPrice, double curPrice) {
		this.currencyType = currencyType;
		this.maxPrice = maxPrice;
		this.minPrice = minPrice;
		this.avgPrice = avgPrice;
		this.curPrice = curPrice;
	}

	public String getCurrencyType() {
		return currencyType;
	}
	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}
	public double getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(double maxPrice) {
		this.maxPrice = maxPrice;
	}
	public double getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(double minPrice) {
		this.minPrice = minPrice;
	}
	public double getAvgPrice() {
		return avgPrice;
	}
	public void setAvgPrice(double avgPrice) {
		this.avgPrice = avgPrice;
	}
	public double getCurPrice() {
		return curPrice;
	}
	public void setCurPrice(double curPrice) {
		this.curPrice = curPrice;
	}	

}
