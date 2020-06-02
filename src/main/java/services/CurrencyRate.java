package services;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

//@Entity
public class CurrencyRate {
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column private Long id;
	@JsonProperty("BTC")
	private double btcPrice;
	@JsonProperty("EUR")
	private double eurPrice;
	@JsonProperty("USD")
	private double usdPrice;
	
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
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
	
	public String toString() {
		return " btc "+btcPrice + " eur " + eurPrice + " usd" + usdPrice;
	}
	
}
