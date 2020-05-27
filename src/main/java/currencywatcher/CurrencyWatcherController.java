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

@Controller
//@RestController
//@RequestMapping("/myapp")
public class CurrencyWatcherController {
	@Autowired private UserDetailsRepository userDetailsRepository;
//	@Autowired private CurrencyRateRepository currencyRateRepository;
	@Autowired private RestTemplate restTemplate;
	
	@GetMapping("/")
	public String greeting(Model model){		
		return "index.html";
	}
	
/*	@RequestMapping("/currencydata")
	public String currencydata(){
			String url = "https://min-api.cryptocompare.com/data/pricemulti?fsyms=ETH,DASH&tsyms=BTC,USD,EUR&api_key=088509e9d87298ed3da6e360e9b21ee3b78abf70109e1c640ac0e6b3b5a4a223";
			String a = restTemplate.getForObject(url, String.class);
			return a;
	}*/
	
//	@PostMapping("/currencyData")
//	public  currencyData(double btcPrice, double eurPrice, double usdPrice) {
//		CurrencyRate currencyRate = new CurrencyRate();
//		currencyRate.setBtcPrice(btcPrice);
//		currencyRate.setEurPrice(eurPrice);
//		currencyRate.setUsdPrice(usdPrice);
//		currencyRateRepository.save(currencyRate);
//		
//		return "index.html";
//	}
	
	@PostMapping("/processForm")
	public void processForm(String firstName, String lastName, String emailAddress, String aboveBelow, int price, String currencyChoice, HttpServletResponse response) throws IOException{
		UserDetails userDetails = new UserDetails();
		userDetails.setFirstName(firstName);
		userDetails.setLastName(lastName);
		userDetails.setEmailAddress(emailAddress);
		userDetails.setAboveBelow(aboveBelow);
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
}

