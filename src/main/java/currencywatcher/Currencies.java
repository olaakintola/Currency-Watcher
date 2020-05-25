package currencywatcher;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Currencies {
	
	@JsonProperty("ETH")
	private CurrencyRate ETH;
	@JsonProperty("DASH")
	private CurrencyRate DASH;
	
	public CurrencyRate getETH() {
		return ETH;
	}
	public void setETH(CurrencyRate eTH) {
		ETH = eTH;
	}
	public CurrencyRate getDASH() {
		return DASH;
	}
	public void setDASH(CurrencyRate dASH) {
		DASH = dASH;
	}

}
