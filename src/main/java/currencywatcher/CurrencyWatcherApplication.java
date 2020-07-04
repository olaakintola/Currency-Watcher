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
	@Autowired private EmailNotification emailNotification;
	List<CurrencyEntity> lst = new ArrayList<CurrencyEntity>();
	List<UserDetails> auser = new ArrayList<UserDetails>();
	@Autowired private PriceCheck priceCheck;
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	private static final Logger log = LoggerFactory.getLogger(CurrencyWatcherApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CurrencyWatcherApplication.class);
	}
	
	@Scheduled(fixedDelay = 20000L)
	void getCurrencies() throws IOException {
		System.out.println("Now is " + new Date () );
		System.out.println( currencyservice );
		System.out.println("");		
		priceCheck.eachValue();		
		System.out.println("");
	}
	
	@Bean
	public CommandLineRunner demo(CurrencyEntityRepository currencyEntityRepository, CryptoCurrencyService cryptoCurrencyService) {
		return (args) ->{
			log.info("Currencies displayed");
			for(CurrencyEntity eachCurrency: currencyEntityRepository.findAll() ) {
				log.info(eachCurrency.toString());
			}
			log.info("");
		};	
	}
}

