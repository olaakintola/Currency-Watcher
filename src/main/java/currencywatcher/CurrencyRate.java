package currencywatcher;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CurrencyRate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column private Long id;
	@Column private double btcPrice;
	@Column private double eurPrice;
	@Column private double usdPrice;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getBtcPrice() {
		return btcPrice;
	}
	public void setBtcPrice(double btcPrice) {
		this.btcPrice = btcPrice;
	}
	public double getEurPrice() {
		return eurPrice;
	}
	public void setEurPrice(double eurPrice) {
		this.eurPrice = eurPrice;
	}
	public double getUsdPrice() {
		return usdPrice;
	}
	public void setUsdPrice(double usdPrice) {
		this.usdPrice = usdPrice;
	}

//	public CurrencyRate() {}
//	public CurrencyRate(String currencyType, double maxPrice, double minPrice, double avgPrice, double curPrice) {
//		this.currencyType = currencyType;
//		this.curPrice = curPrice;
//	}
	
	
}
