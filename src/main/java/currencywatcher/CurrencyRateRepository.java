package currencywatcher;

import org.springframework.data.jpa.repository.JpaRepository;

import services.CurrencyRate;

public interface CurrencyRateRepository extends JpaRepository<CurrencyRate, Long> {

}
