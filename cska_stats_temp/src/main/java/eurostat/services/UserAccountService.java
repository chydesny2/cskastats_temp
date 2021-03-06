package eurostat.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eurostat.dto.UserAccountRepository;
import eurostat.entities.UserAccount;

@Service
public class UserAccountService {
	@Autowired 
	UserAccountRepository uRepo;
	
	public List<UserAccount> findAll() {
		return uRepo.findAll();
	}
	
	
	public UserAccount findByEmail(String email) {
		return uRepo.findByEmail(email);
	}
	
	public void save(UserAccount useraccount) {
		uRepo.save(useraccount);
	}
	
	public UserAccount findByUserName(String username) {
		return uRepo.findByUserName(username);
	}
}
