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
	@Column private String aboveBelow;
	@Column private double price;
	@Column private String currencyChoice;
	@Column private String emailSent;

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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCurrencyChoice() {
		return currencyChoice;
	}
	public void setCurrencyChoice(String currencyChoice) {
		this.currencyChoice = currencyChoice;
	}
	public String getAboveBelow() {
		return aboveBelow;
	}
	public void setAboveBelow(String aboveBelow) {
		this.aboveBelow = aboveBelow;
	}
	public String getEmailSent() {
		return emailSent;
	}
	public void setEmailSent(String emailSent) {
		this.emailSent = emailSent;
	}
	public String toString() {
		return firstName+" "+ lastName+" "+" "+ emailAddress+" "+" "+currenciesType+" "+ aboveBelow +" "+price+" "+ currencyChoice;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aboveBelow == null) ? 0 : aboveBelow.hashCode());
		result = prime * result + ((currenciesType == null) ? 0 : currenciesType.hashCode());
		result = prime * result + ((currencyChoice == null) ? 0 : currencyChoice.hashCode());
		result = prime * result + ((emailAddress == null) ? 0 : emailAddress.hashCode());
		result = prime * result + ((emailSent == null) ? 0 : emailSent.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDetails other = (UserDetails) obj;
		if (aboveBelow == null) {
			if (other.aboveBelow != null)
				return false;
		} else if (!aboveBelow.equals(other.aboveBelow))
			return false;
		if (currenciesType == null) {
			if (other.currenciesType != null)
				return false;
		} else if (!currenciesType.equals(other.currenciesType))
			return false;
		if (currencyChoice == null) {
			if (other.currencyChoice != null)
				return false;
		} else if (!currencyChoice.equals(other.currencyChoice))
			return false;
		if (emailAddress == null) {
			if (other.emailAddress != null)
				return false;
		} else if (!emailAddress.equals(other.emailAddress))
			return false;
		if (emailSent == null) {
			if (other.emailSent != null)
				return false;
		} else if (!emailSent.equals(other.emailSent))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		return true;
	}
	
	

}
