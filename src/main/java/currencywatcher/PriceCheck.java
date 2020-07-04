package currencywatcher;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PriceCheck {
	
	@Autowired CurrencyService currencyservice;
	@Autowired CryptoCurrencyService cryptoCurrencyService;
	@Autowired private CurrencyEntityRepository currencyEntityRepository;
	@Autowired private UserDetailsRepository userDetailsRepository;
	@Autowired private RestTemplate restTemplate;
	@Autowired private EmailNotification emailNotification;
	List<CurrencyEntity> lst = new ArrayList<CurrencyEntity>();
	List<UserDetails> auser = new ArrayList<UserDetails>();
	
	public PriceCheck() {}
	
	
	public void eachValue() throws IOException {
		String emailSent = "Email Sent";
		UserDetails tempUser = new UserDetails ();
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
								if(auser.get(i).getEmailSent().equals("No Email Sent")) {
									System.out.println("Send Email for above ethbtc");
									tempUser = auser.get(i);
									emailNotification.sendEmail( tempUser);
									tempUser.setEmailSent(emailSent);
//									auser.get(i).setEmailSent(emailSent);
									userDetailsRepository.save( tempUser);	// try saveAll, if save doesnt work
									}
								}
							}else if(auser.get(i).getAboveBelow().equals("below")) {
								if(auser.get(i).getPrice() > (lst.get(j).getEthBtc() ) ) {
									if(auser.get(i).getEmailSent().equals("No Email Sent")) {
										System.out.println("Send email for below ethbtc");
										tempUser = auser.get(i);
										emailNotification.sendEmail( tempUser);
										tempUser.setEmailSent(emailSent);
//										auser.get(i).setEmailSent(emailSent);
										userDetailsRepository.save( tempUser );	// try saveAll, if save doesnt work			
										}
									}
								}
						}else if( auser.get(i).getCurrencyChoice().equals("US Dollars")  ) {
							if(auser.get(i).getAboveBelow().equals("above") ) {
								if(auser.get(i).getPrice() < (lst.get(j).getEthUsd() ) ) {
									if(auser.get(i).getEmailSent().equals("No Email Sent") ) {
										System.out.println("Send Email for above ethusd");
										tempUser = auser.get(i);
										emailNotification.sendEmail( tempUser);
										tempUser.setEmailSent(emailSent);
	//									auser.get(i).setEmailSent(emailSent);
										userDetailsRepository.save( tempUser);
									}	
								}	
							}else if(auser.get(i).getAboveBelow().equals("below")) {
								if(auser.get(i).getPrice() > (lst.get(j).getEthUsd() ) ) {
									if( auser.get(i).getEmailSent().equals("No Email Sent")  ) {
										System.out.println("Send email for below ethusd");
										tempUser = auser.get(i);
										emailNotification.sendEmail( tempUser);
										tempUser.setEmailSent(emailSent);
	//									auser.get(i).setEmailSent(emailSent);
										userDetailsRepository.save( tempUser);
									}	
								}		
							}	
						}else if( auser.get(i).getCurrencyChoice().equals("EUR")  ) {
								if(auser.get(i).getAboveBelow().equals("above") ) {
									if(auser.get(i).getPrice() < (lst.get(j).getEthEur() ) ) {
										if( auser.get(i).getEmailSent().equals("No Email Sent")  ) {
											System.out.println("Send Email for above etheur");
											tempUser = auser.get(i);
											emailNotification.sendEmail( tempUser);
											tempUser.setEmailSent(emailSent);
//											auser.get(i).setEmailSent(emailSent);
											userDetailsRepository.save( tempUser);
											}
										}
									}
								else if(auser.get(i).getAboveBelow().equals("below")) {
									if(auser.get(i).getPrice() > (lst.get(j).getEthEur() ) ) {
										if(  auser.get(i).getEmailSent().equals("No Email Sent") ) {
											System.out.println("Send email for below etheur");
											tempUser = auser.get(i);
											emailNotification.sendEmail( tempUser);
											tempUser.setEmailSent(emailSent);
	//										auser.get(i).setEmailSent(emailSent);
											userDetailsRepository.save( tempUser);
										}	
									}
								}
							}
					}else if( auser.get(i).getCurrenciesType().equalsIgnoreCase("dash") )  {
						if(auser.get(i).getCurrencyChoice().equals("Bitcoin") ) {
							if(auser.get(i).getAboveBelow().equals("above") ) {
								if(auser.get(i).getPrice() < (lst.get(j).getDashBtc() ) ) {
									if( auser.get(i).getEmailSent().equals("No Email Sent") ) { 
										System.out.println("Send Email for above dashbtc");
										tempUser = auser.get(i);
										emailNotification.sendEmail( tempUser);
										tempUser.setEmailSent(emailSent);
	//									auser.get(i).setEmailSent(emailSent);
										userDetailsRepository.save( tempUser);
									}
								}	
							}else if(auser.get(i).getAboveBelow().equals("below")) {
									if(auser.get(i).getPrice() > (lst.get(j).getDashBtc() ) ) {
										if( auser.get(i).getEmailSent().equals("No Email Sent")  ) {
											System.out.println("Send email for below dashbtc");
											tempUser = auser.get(i);
											emailNotification.sendEmail( tempUser);
											tempUser.setEmailSent(emailSent);
		//									auser.get(i).setEmailSent(emailSent);
											userDetailsRepository.save( tempUser);
										}
									}
								}
						}else if( auser.get(i).getCurrencyChoice().equals("US Dollars") ) {
							if(auser.get(i).getAboveBelow().equals("above") ) {
								if(auser.get(i).getPrice() < (lst.get(j).getDashUsd() ) ) {
									if( auser.get(i).getEmailSent().equals("No Email Sent") ) {
										System.out.println("Send Email for above dashusd");
										tempUser = auser.get(i);
										emailNotification.sendEmail( tempUser);
										tempUser.setEmailSent(emailSent);
	//									auser.get(i).setEmailSent(emailSent);
										userDetailsRepository.save( tempUser);
									}
								}
							}else if(auser.get(i).getAboveBelow().equals("below")) {
								if(auser.get(i).getPrice() > (lst.get(j).getDashUsd() ) ) {
									if( auser.get(i).getEmailSent().equals("No Email Sent")  ) {	
										System.out.println("Send email for below dashusd");
										tempUser = auser.get(i);
										emailNotification.sendEmail( tempUser);
										tempUser.setEmailSent(emailSent);
	//									auser.get(i).setEmailSent(emailSent);
										userDetailsRepository.save( tempUser);
									}	
								}
							}	
						}else if( auser.get(i).getCurrencyChoice().equals("EUR")  ) {
							if(auser.get(i).getAboveBelow().equals("above") ) {
								if(auser.get(i).getPrice() < (lst.get(j).getDashEur() ) ) {
									if( auser.get(i).getEmailSent().equals("No Email Sent") ) {
										System.out.println("Send Email for above dasheur");
										tempUser = auser.get(i);
										emailNotification.sendEmail( tempUser);
										tempUser.setEmailSent(emailSent);
	//									auser.get(i).setEmailSent(emailSent);
										userDetailsRepository.save( tempUser);	
									}
								}
							}else if(auser.get(i).getAboveBelow().equals("below")) {
								if(auser.get(i).getPrice() > (lst.get(j).getDashEur() ) ) {
									if( auser.get(i).getEmailSent().equals("No Email Sent") ) {
										System.out.println("Send email for below dasheur");
										tempUser = auser.get(i);
										emailNotification.sendEmail( tempUser);
										tempUser.setEmailSent(emailSent);
	//									auser.get(i).setEmailSent(emailSent);
										userDetailsRepository.save( tempUser);
										
									}
								}
							}
						}
					}
				}
			}
		
		cryptoCurrencyService.delete();
	}

}
