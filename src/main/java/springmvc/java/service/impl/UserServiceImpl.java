package springmvc.java.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springmvc.java.dao.UserDAO;
import springmvc.java.domain.User;
import springmvc.java.service.UserService;

public class UserServiceImpl implements UserService {

	private static final Logger lOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDAO userDAO;

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		lOGGER.info("In save user method");
		return userDAO.save(user);
	}

	@Override
	public User findUser(String userId) {

		return userDAO.findOne(userId);
	}

}
