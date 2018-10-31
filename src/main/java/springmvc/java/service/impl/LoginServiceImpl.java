package springmvc.java.service.impl;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ch.qos.logback.classic.Logger;
import springmvc.java.dao.LoginDAO;
import springmvc.java.domain.User;
import springmvc.java.service.LoginService;

public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDAO loginDAO;

	private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(LoginServiceImpl.class);

	@Override
	public User findUser(String userId) {

		return loginDAO.findOne(userId);
	}

}
