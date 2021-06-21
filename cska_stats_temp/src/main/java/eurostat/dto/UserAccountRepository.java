package eurostat.dto;

import java.util.List;

import javax.persistence.Table;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import eurostat.entities.UserAccount;

@Repository
@Table(name="user_accounts")
public interface UserAccountRepository extends PagingAndSortingRepository<UserAccount, Long>{
	
	@Override
	public List<UserAccount> findAll();
	
	public UserAccount findByEmail(String email);
	
	public UserAccount findByUserName(String username);

}
