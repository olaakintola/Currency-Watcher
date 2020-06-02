package services;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Currencies {
	
	@JsonProperty("ETH")
	private CurrencyRate eth;
	@JsonProperty("DASH")
	private CurrencyRate dash;
	
	public CurrencyRate getEth() {
		return eth;
	}
	public void setEth(CurrencyRate eth) {
		this.eth = eth;
	}
	public CurrencyRate getDash() {
		return dash;
	}
	public void setDash(CurrencyRate dash) {
		this.dash = dash;
	}
	
	public String toString() {
		return "ETH " + eth + "\nDASH " + dash;
	}

}
