package currencywatcher;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import services.Currencies;

@Controller
//@RestController
//@RequestMapping("/myapp")
public class CurrencyWatcherController {
	@Autowired private UserDetailsRepository userDetailsRepository;
	@Autowired private CurrencyEntityRepository currencyEntityRepository;
	@Autowired private RestTemplate restTemplate;
	
	@GetMapping("/")
	public String greeting(Model model){
		return "index.html";
	}
	
	
	@PostMapping("/processForm")
	public void processForm(String firstName, String lastName, String emailAddress, String currenciesType, int price, String currencyChoice, HttpServletResponse response) throws IOException{
		UserDetails userDetails = new UserDetails();
		userDetails.setFirstName(firstName);
		userDetails.setLastName(lastName);
		userDetails.setEmailAddress(emailAddress);
		userDetails.setCurrenciesType(currenciesType);
		userDetails.setPrice(price);
		userDetails.setCurrencyChoice(currencyChoice);
		userDetailsRepository.save(userDetails);

		response.sendRedirect("/display");
	}
	
	@GetMapping("/display")
	public String display(Model model) {
		model.addAttribute("userDetails", userDetailsRepository.findAll());
		
		return "display.html";
	}
	
	@GetMapping("/storeApi")
	public void storeApi( Currencies acurrency, HttpServletResponse response ) throws IOException {
		String url = "https://min-api.cryptocompare.com/data/pricemulti?fsyms=ETH,DASH&tsyms=BTC,USD,EUR&api_key=088509e9d87298ed3da6e360e9b21ee3b78abf70109e1c640ac0e6b3b5a4a223";
		acurrency = restTemplate.getForObject(url, Currencies.class);		
		CurrencyEntity currencyEntity = new CurrencyEntity ();
		currencyEntity.setEthBtc(acurrency.getEth().getBtcPrice());
		currencyEntity.setEthEur(acurrency.getEth().getEurPrice());
		currencyEntity.setEthUsd(acurrency.getEth().getUsdPrice());
		currencyEntity.setDashBtc(acurrency.getDash().getBtcPrice());
		currencyEntity.setDashEur(acurrency.getDash().getEurPrice());
		currencyEntity.setDashUsd(acurrency.getDash().getUsdPrice());
		currencyEntityRepository.save(currencyEntity);
		
		response.sendRedirect("/");
	}
}

