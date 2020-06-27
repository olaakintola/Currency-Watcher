package currencywatcher.userdetails;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Long>{

	UserDetails findByEmailAddress(String emailAddress);

}
