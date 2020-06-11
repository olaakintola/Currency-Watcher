package currencywatcher;

import java.io.IOException;
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
	@Autowired CryptoCurrencyService cryptoCurrencyService;
	@Autowired private CurrencyEntityRepository currencyEntityRepository;
	@Autowired private UserDetailsRepository userDetailsRepository;
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
	void getCurrencies() throws IOException {
		System.out.println("Now is " + new Date () );
		System.out.println( currencyservice );
		cryptoCurrencyService.updateCurrencies();	
		System.out.println("");
		
/*		for(CurrencyEntity eachCurrency: currencyEntityRepository.findAll() ) {
			System.out.println(eachCurrency.toString());
		}*/
		
//		cryptoCurrencyService.delete();
		checkPrice();
		System.out.println("");
	}
	
	@Bean
	public CommandLineRunner demo(CurrencyEntityRepository currencyEntityRepository, CryptoCurrencyService cryptoCurrencyService) {
		return (args) ->{
			// save currencies
			cryptoCurrencyService.updateCurrencies();			
			// fetch currencies
			log.info("Currencies displayed");
			for(CurrencyEntity eachCurrency: currencyEntityRepository.findAll() ) {
				log.info(eachCurrency.toString());
			}
			log.info("");
		};
		
	}
	
	public void checkPrice(){
/*		List<CurrencyEntity> priceData = new ArrayList<CurrencyEntity>();
		priceData = currencyEntityRepository.findAll();
		for(int i = 0; i < priceData.size(); i++) {
			System.out.println(priceData.get(i).getDashBtc());
		}*/
		System.out.println("Displaying Content of Currency DB");
		for(CurrencyEntity eachCurrency: currencyEntityRepository.findAll() ) {
			System.out.println(eachCurrency.toString());
		}
		System.out.println("");
		System.out.println("Displaying Content of User DB");
		for(UserDetails eachUser: userDetailsRepository.findAll() ) {
			System.out.println(eachUser.toString());
		}
		

		
	}
	
//	private void sendEmail() {
//		
//	}

}
