package currencywatcher;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
	@Autowired private CryptoCurrencyService cryptoCurrencyService;
	@Autowired private EmailValidator emailValidator;
	
	@GetMapping("/")
	public String greeting(Model model){
//		model.addAttribute("currencyEntity", currencyEntityRepository.findAll());
		return "index.html";
	}
	
	@PostMapping("/processForm")
	public void processForm(String firstName, String lastName, String emailAddress, String currenciesType, double price, String aboveBelow, String currencyChoice, HttpServletResponse response) throws IOException{

		if( emailValidator.validUser(emailAddress, firstName, lastName) ) {
			String emailSent = "No Email Sent";
			UserDetails userDetails = new UserDetails();
			userDetails.setFirstName(firstName);
			userDetails.setLastName(lastName);
			userDetails.setEmailAddress(emailAddress);
			userDetails.setCurrenciesType(currenciesType);
			userDetails.setPrice(price);
			userDetails.setCurrencyChoice(currencyChoice);
			userDetails.setAboveBelow(aboveBelow);
			userDetails.setEmailSent(emailSent);
			userDetailsRepository.save(userDetails);
			response.sendRedirect("/display");
			}else {
			response.sendRedirect("/adduser");
		}
	}
	
	@GetMapping("/display")
	public String display(Model model) {
		model.addAttribute("userDetails", userDetailsRepository.findAll());
		return "display.html";
	}
	
	@GetMapping("/storeApi")
	public void storeApi( Currencies acurrency, HttpServletResponse response ) throws IOException {
		cryptoCurrencyService.updateCurrencies();
		response.sendRedirect("/");
	}
	
	@GetMapping("/adduser")
	public String changeEmail(Model model) {
		return "adduser.html";
	}
	
}

