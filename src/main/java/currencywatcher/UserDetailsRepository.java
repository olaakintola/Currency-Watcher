package currencywatcher;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Long>{

	void save(List<UserDetails> auser);

//	void saveAll(List<UserDetails> auser);

}
