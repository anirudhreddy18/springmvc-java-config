package springmvc.java.service;

import springmvc.java.domain.User;

public interface UserService {

	User saveUser(User user);
	
	User findUser(String userId);
}
