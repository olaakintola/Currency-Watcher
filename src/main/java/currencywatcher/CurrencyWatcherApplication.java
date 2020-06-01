package currencywatcher;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

@EnableScheduling
@SpringBootApplication
public class CurrencyWatcherApplication {
	
	@Autowired CurrencyService currencyservice;
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(CurrencyWatcherApplication.class, args);
	}
	
	@Scheduled(fixedDelay = 2000L)
	void getCurrencies() {
		System.out.println("Now is " + currencyservice.currencydata() );
//		System.out.println("Now is " + new Date () );

	}

}
