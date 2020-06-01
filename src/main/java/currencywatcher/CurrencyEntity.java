package currencywatcher;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CurrencyEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column private Long id;
	@Column private double ethBtc;
	@Column private double ethEur;
	@Column private double ethUsd;
	@Column private double dashBtc;
	@Column private double dashEur;
	@Column private double dashUsd;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getEthBtc() {
		return ethBtc;
	}
	public void setEthBtc(double ethBtc) {
		this.ethBtc = ethBtc;
	}
	public double getEthEur() {
		return ethEur;
	}
	public void setEthEur(double ethEur) {
		this.ethEur = ethEur;
	}
	public double getEthUsd() {
		return ethUsd;
	}
	public void setEthUsd(double ethUsd) {
		this.ethUsd = ethUsd;
	}
	public double getDashBtc() {
		return dashBtc;
	}
	public void setDashBtc(double dashBtc) {
		this.dashBtc = dashBtc;
	}
	public double getDashEur() {
		return dashEur;
	}
	public void setDashEur(double dashEur) {
		this.dashEur = dashEur;
	}
	public double getDashUsd() {
		return dashUsd;
	}
	public void setDashUsd(double dashUsd) {
		this.dashUsd = dashUsd;
	}
	
}
