package currencywatcher;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.stereotype.Component;

//@Component
@Entity

public class UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String aboveBelow;
	private int price;
	private String currencyChoice;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getAboveBelow() {
		return aboveBelow;
	}
	public void setAboveBelow(String aboveBelow) {
		this.aboveBelow = aboveBelow;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCurrencyChoice() {
		return currencyChoice;
	}
	public void setCurrencyChoice(String currencyChoice) {
		this.currencyChoice = currencyChoice;
	}

}
