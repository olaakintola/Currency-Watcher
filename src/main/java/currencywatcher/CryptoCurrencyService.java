package currencywatcher;

import org.springframework.stereotype.Service;

public class CryptoCurrencyService {
	
	CurrencyService currencyservice;

	public CurrencyService getCurrencyservice() {
		return currencyservice;
	}

	public void setCurrencyservice(CurrencyService currencyservice) {
		this.currencyservice = currencyservice;
	}
	
	public String toString() {
		return currencyservice + " .";
	}
	
}
