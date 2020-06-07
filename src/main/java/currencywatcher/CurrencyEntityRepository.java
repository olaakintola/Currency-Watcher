package currencywatcher;

import org.springframework.data.jpa.repository.JpaRepository;

import services.Currencies;

public interface CurrencyEntityRepository extends JpaRepository<CurrencyEntity, Long>{

	void save(Currencies currencies);

}
