package currencywatcher;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.Assert;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import services.Currencies;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {CurrencyWatcherApplication.class})
@TestPropertySource(locations="classpath:application.properties")
class CurrencyWatcherControllerIntegrationTests {

	@LocalServerPort private int port;
	@Autowired private TestRestTemplate  testRestTemplate;
	@Autowired private UserDetailsRepository userDetailsRepository;
	@Autowired private CurrencyService client;
	@Autowired CurrencyEntityRepository currencyEntityRepository;
	@Autowired PriceCheck priceCheck;
	@Autowired CryptoCurrencyService cryptoCurrencyService;
	
	List<UserDetails> auser = new ArrayList<UserDetails>();
	
	@Test
	public void testHTTPRequest() throws Exception {
		assertThat(this.testRestTemplate.getForObject("http://localhost:" + port + "/", String.class)).contains("index.html");
	}
	
	@Test
	public void testServiceCall() {
		String url = "https://min-api.cryptocompare.com/data/pricemulti?fsyms=ETH,DASH&tsyms=BTC,USD,EUR&api_key=088509e9d87298ed3da6e360e9b21ee3b78abf70109e1c640ac0e6b3b5a4a223";
		Currencies response = testRestTemplate.getForObject(url, Currencies.class);
		assertThat(client.currencydata() ).isEqualTo(response);
	}
	
	@Test
	public void testFindAll() {
		List<UserDetails> users = userDetailsRepository.findAll();
		Assert.isNull(users, "UserDetailsRepository must be null");
	}
	
	@Test
	public void testCryptoCurrency() throws IOException {
		CryptoCurrencyService cryptoCurrencyService = new CryptoCurrencyService ();
		cryptoCurrencyService.updateCurrencies();
		cryptoCurrencyService.delete();
		Assert.isNull(currencyEntityRepository.findAll(), "CryptocurrencyService isn't working as it should");
	}
	
	@Test
	public void testProcessForm() throws Exception {
		String emailSent = "No Email Sent";
		UserDetails userDetails = new UserDetails();
		userDetails.setFirstName("Ola");
		userDetails.setLastName("AKin");
		userDetails.setEmailAddress("olamoiakin@gmail");
		userDetails.setCurrenciesType("dash");
		userDetails.setPrice(10.01);
		userDetails.setCurrencyChoice("bitcoin");
		userDetails.setAboveBelow("above");
		userDetails.setEmailSent(emailSent);
		userDetailsRepository.save(userDetails);

		Assert.notNull(userDetailsRepository.findAll(), "UserDetails is meant to have content");
	}
	
	@Test
	public void testEachValue() throws IOException {
		
		String emailSent = "No Email Sent";
		UserDetails userDetails = new UserDetails();
		userDetails.setFirstName("Ola");
		userDetails.setLastName("AKin");
		userDetails.setEmailAddress("olamoiakin@gmail");
		userDetails.setCurrenciesType("dash");
		userDetails.setPrice(1.1);
		userDetails.setCurrencyChoice("US Dollars");
		userDetails.setAboveBelow("above");
		userDetails.setEmailSent(emailSent);
		userDetailsRepository.save(userDetails);
		
		priceCheck.eachValue();
		
		auser = userDetailsRepository.findAll();
		UserDetails tempUser = new UserDetails();
		tempUser = auser.get(0);
		String emailStatus = tempUser.getEmailSent();
		String expectedStatus = "Email Sent";
		
	    assertEquals(emailStatus, expectedStatus);		
	}
	
}
