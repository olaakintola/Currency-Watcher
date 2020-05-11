package currencywatcher;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller

public class CurrencyWatcherController {
	
	@Autowired private UserDetails userDetails;
	
	@GetMapping("/greeting")

	public String greeting(Model model){
		ArrayList<CurrencyRate> dailyRates = new ArrayList<CurrencyRate>();
		dailyRates.add(new CurrencyRate("Bitcoin ", 8800, 8000, 8400, 8300));
		dailyRates.add(new CurrencyRate("GB-Pound ", 0.90, 0.50, 0.70, 0.60));
		dailyRates.add(new CurrencyRate("US Dollars ", 1.13, 1.11, 1.12, 1.12));
		model.addAttribute("dailyRates", dailyRates);
		
		return "index.html";
	}
	
	@PostMapping("/processForm")
	
	public String processForm(String firstName, String lastName, String emailAddress, String aboveBelow, int price, String currencyChoice) {
		userDetails.setFirstName(firstName);
		userDetails.setLastName(lastName);
		userDetails.setEmailAddress(emailAddress);
		userDetails.setAboveBelow(aboveBelow);
		userDetails.setPrice(price);
		userDetails.setCurrencyChoice(currencyChoice);

		return "adduser.html";
	}
	
	@GetMapping("/display")
	public String display(Model model) {
		model.addAttribute("userDetails", userDetails);
		
		return "display.html";
	}
}

