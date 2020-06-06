package currencywatcher;

import javax.persistence.Column;
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
	@Column private Long id;
	@Column private String firstName;
	@Column private String lastName;
	@Column private String emailAddress;
	@Column private String currenciesType;
	@Column private int price;
	@Column private String currencyChoice;

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
	public String getCurrenciesType() {
		return currenciesType;
	}
	public void setCurrenciesType(String currenciesType) {
		this.currenciesType = currenciesType;
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
