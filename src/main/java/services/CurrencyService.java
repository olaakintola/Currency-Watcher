package services;

import java.util.List;

import org.assertj.core.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import services.Currencies;

@Service
public class CurrencyService {
	
	@Autowired private RestTemplate restTemplate;

	@Value("${currency.url}")
	String url;
	
	public Currencies currencydata(){
			Currencies currencies = restTemplate.getForObject(url, Currencies.class);
			return currencies;
	}
	
	public String toString() {
		return currencydata() + " ";
	}

}
