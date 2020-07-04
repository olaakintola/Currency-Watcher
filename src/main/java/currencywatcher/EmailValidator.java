package currencywatcher;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailValidator {
	
	@Autowired 
	private UserDetailsRepository userDetailsRepository;
	
	public EmailValidator() {}
	
	public boolean validUser(String emailAddress, String firstName, String lastName ) {
		List<UserDetails> auser = new ArrayList<UserDetails>();
		auser = userDetailsRepository.findAll();
		for(int i = 0; i < auser.size(); i++) {
			if( auser.get(i).getEmailAddress().equals(emailAddress) && ! ( ( auser.get(i).getFirstName().equals(firstName) ) && ( auser.get(i).getLastName().equals(lastName) ) ) ) {
				return false;
			}
		}
		return true;
	}
	
	public boolean emailSentStatus(String emailAddress) {
		List<UserDetails> auser = new ArrayList<UserDetails>();
		auser = userDetailsRepository.findAll();
		for(int i = 0; i < auser.size(); i++) {
			if(auser.get(i).getEmailAddress().equals(emailAddress) && ( auser.get(i).getEmailSent().equals("Email Sent") ) ) {
//				UserDetails tempUser = auser.get(i);
//				tempUser.setAboveBelow(aboveBelow);
//				tempUser.setCurrenciesType(currenciesType);
//				tempUser.setCurrencyChoice(currencyChoice);
//				tempUser.setPrice(price);
//				userDetailsRepository.save(tempUser);
				return true;
			}
		}
		return false;
	}
	

}
