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
	List<CurrencyEntity> lst = new ArrayList<CurrencyEntity>();
	List<UserDetails> auser = new ArrayList<UserDetails>();
	
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
//		cryptoCurrencyService.updateCurrencies();	
		System.out.println("");
		
/*		for(CurrencyEntity eachCurrency: currencyEntityRepository.findAll() ) {
			System.out.println(eachCurrency.toString());
		}*/
		eachValue();		
//		cryptoCurrencyService.delete();
//		checkPrice();
		System.out.println("");

	}
	
	@Bean
	public CommandLineRunner demo(CurrencyEntityRepository currencyEntityRepository, CryptoCurrencyService cryptoCurrencyService) {
		return (args) ->{
			// save currencies
//			cryptoCurrencyService.updateCurrencies();			
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
	
	public void eachValue() throws IOException {
		cryptoCurrencyService.updateCurrencies();	
		System.out.println(currencyEntityRepository.count() );
		auser = userDetailsRepository.findAll();
		lst = currencyEntityRepository.findAll();
		for(int j = 0; j < lst.size(); j++) {
			for(int i = 0; i < auser.size(); i++) {
	//			System.out.println(auser.get(i).getCurrenciesType().toString() );
				if( auser.get(i).getCurrenciesType().equalsIgnoreCase("etherium") ) {
					System.out.println("I chose etherium");
//					System.out.println(auser.get(i).getCurrencyChoice().toString() );
					if(auser.get(i).getCurrencyChoice().equals("Bitcoin") ) {
						System.out.println("Bitcoin");
						if(auser.get(i).getAboveBelow().equals("above") ) {
							if(auser.get(i).getPrice() < (lst.get(j).getEthBtc() ) ) {
								System.out.println("Send Email for above ethbtc");
								}
							}else if(auser.get(i).getAboveBelow().equals("below")) {
								if(auser.get(i).getPrice() > (lst.get(j).getEthBtc() ) ) {
									System.out.println("Send email for below ethbtc");
									}
								}
						}else if( auser.get(i).getCurrencyChoice().equals("US Dollars")  ) {
							if(auser.get(i).getAboveBelow().equals("above") ) {
								if(auser.get(i).getPrice() < (lst.get(j).getEthUsd() ) ) {
									System.out.println("Send Email for above ethusd");
									}
								}else if(auser.get(i).getAboveBelow().equals("below")) {
									if(auser.get(i).getPrice() > (lst.get(j).getEthUsd() ) ) {
										System.out.println("Send email for below ethusd");
										}
									}
							}else if( auser.get(i).getCurrencyChoice().equals("EUR")  ) {
								if(auser.get(i).getAboveBelow().equals("above") ) {
									if(auser.get(i).getPrice() < (lst.get(j).getEthEur() ) ) {
										System.out.println("Send Email for above etheur");
										}
									}
								else if(auser.get(i).getAboveBelow().equals("below")) {
									if(auser.get(i).getPrice() > (lst.get(j).getEthEur() ) ) {
										System.out.println("Send email for below etheur");
								}
							}
						}
					}else if( auser.get(i).getCurrenciesType().equalsIgnoreCase("dash") )  {
						if(auser.get(i).getCurrencyChoice().equals("Bitcoin") ) {
							if(auser.get(i).getAboveBelow().equals("above") ) {
								if(auser.get(i).getPrice() < (lst.get(j).getDashBtc() ) ) {
								System.out.println("Send Email for above dashbtc");
								}
								}else if(auser.get(i).getAboveBelow().equals("below")) {
									if(auser.get(i).getPrice() > (lst.get(j).getDashBtc() ) ) {
									System.out.println("Send email for below dashbtc");
									}
								}
						}else if( auser.get(i).getCurrencyChoice().equals("US Dollars") ) {
							if(auser.get(i).getAboveBelow().equals("above") ) {
								if(auser.get(i).getPrice() < (lst.get(j).getDashUsd() ) ) {
									System.out.println("Send Email for above dashusd");
								}
							}else if(auser.get(i).getAboveBelow().equals("below")) {
								if(auser.get(i).getPrice() > (lst.get(j).getDashUsd() ) ) {
									System.out.println("Send email for below dashusd");
							}
						}
					}else if( auser.get(i).getCurrencyChoice().equals("EUR")  ) {
						if(auser.get(i).getAboveBelow().equals("above") ) {
							if(auser.get(i).getPrice() < (lst.get(j).getDashEur() ) ) {
								System.out.println("Send Email for above dasheur");
								}
							}else if(auser.get(i).getAboveBelow().equals("below")) {
								if(auser.get(i).getPrice() > (lst.get(j).getDashEur() ) ) {
									System.out.println("Send email for below dasheur");
							}
						}
					}
				}
			}
		}
		cryptoCurrencyService.delete();

/*		lst = currencyEntityRepository.findAll();
		for(int i = 0; i < lst.size();i++) {
			System.out.println(lst.get(i)  );
		}*/
	
	}
	
//	private void sendEmail() {
//		
//	}
}

