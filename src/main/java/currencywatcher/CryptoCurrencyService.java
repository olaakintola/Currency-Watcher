package currencywatcher;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import services.Currencies;

@Service
public class CryptoCurrencyService {
	
	@Autowired CurrencyService currencyService;
	@Autowired CurrencyEntityRepository currencyEntityRepository;
	
//	@GetMapping("/storeApi")
	public void updateCurrencies( ) throws IOException {
		
		Currencies acurrency = currencyService.currencydata();
		CurrencyEntity currencyEntity = new CurrencyEntity ();
		currencyEntity.setEthBtc(acurrency.getEth().getBtcPrice());
		currencyEntity.setEthEur(acurrency.getEth().getEurPrice());
		currencyEntity.setEthUsd(acurrency.getEth().getUsdPrice());
		currencyEntity.setDashBtc(acurrency.getDash().getBtcPrice());
		currencyEntity.setDashEur(acurrency.getDash().getEurPrice());
		currencyEntity.setDashUsd(acurrency.getDash().getUsdPrice());
		currencyEntityRepository.save(currencyEntity);	
		}
	
	public void delete() {
//		currencyEntityRepository.deleteById(id);
		currencyEntityRepository.deleteAll();
	}
	
//	public Long count() {
//		return currencyEntityRepository.count();
//	} 
}
	
