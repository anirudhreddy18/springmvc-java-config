package springmvc.java.service;

import springmvc.java.domain.User;

public interface LoginService {

	User findUser(String userId);

}
