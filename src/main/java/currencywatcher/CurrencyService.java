package currencywatcher;

import java.util.List;

import org.assertj.core.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import services.Currencies;

//@RestController
//@RequestMapping("/currency")
@Service
public class CurrencyService {
	
	@Autowired private RestTemplate restTemplate;
	
//	@RequestMapping("/currencydata")
	public Currencies currencydata(){
			String url = "https://min-api.cryptocompare.com/data/pricemulti?fsyms=ETH,DASH&tsyms=BTC,USD,EUR&api_key=088509e9d87298ed3da6e360e9b21ee3b78abf70109e1c640ac0e6b3b5a4a223";
			Currencies currencies = restTemplate.getForObject(url, Currencies.class);
			return currencies;
	}
	
	public String toString() {
		return currencydata() + " ";
	}

}
