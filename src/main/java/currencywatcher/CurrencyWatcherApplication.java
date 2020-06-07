package currencywatcher;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import services.Currencies;

@EnableScheduling
@SpringBootApplication
public class CurrencyWatcherApplication {
	
	@Autowired CurrencyService currencyservice;
//	@Autowired CryptoCurrencyService cryptocurrencyservice;
	@Autowired private CurrencyEntityRepository currencyEntityRepository;
	@Autowired private RestTemplate restTemplate;
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	private static final Logger log = LoggerFactory.getLogger(CurrencyWatcherApplication.class);

	public static void main(String[] args) {
//		SpringApplication.run(CurrencyWatcherApplication.class, args);
		SpringApplication.run(CurrencyWatcherApplication.class);
	}
	
	@Scheduled(fixedDelay = 20000L)
	void getCurrencies() {
		System.out.println("Now is " + new Date () );
		System.out.println( currencyservice );
		System.out.println("");
//		checkPrice();
	}
	
	@Bean
	public CommandLineRunner demo(CurrencyEntityRepository currencyEntityRepository) {
		return (args) ->{
			// save currencies
			String url = "https://min-api.cryptocompare.com/data/pricemulti?fsyms=ETH,DASH&tsyms=BTC,USD,EUR&api_key=088509e9d87298ed3da6e360e9b21ee3b78abf70109e1c640ac0e6b3b5a4a223";
			Currencies currencies = restTemplate.getForObject(url, Currencies.class);
			currencyEntityRepository.save(currencies);
			
			// fetch currencies
			log.info("Currencies displayed");
			for(CurrencyEntity eachCurrency: currencyEntityRepository.findAll() ) {
				log.info(eachCurrency.toString());
			}
			log.info("");
		};
		
	}
	
//	public void checkPrice(){
//		List<CurrencyEntity> priceData = new ArrayList<CurrencyEntity>();
//		priceData = currencyEntityRepository.findAll();
//		for(int i = 0; i < priceData.size(); i++) {
//			System.out.println(priceData.get(i).getDashBtc());
//		}
//		
//	}
	
//	private void sendEmail() {
//		
//	}

}
