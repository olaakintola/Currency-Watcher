package services;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Currencies {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@JsonProperty("ETH")
	private CurrencyRate eth;
	@JsonProperty("DASH")
	private CurrencyRate dash;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
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
