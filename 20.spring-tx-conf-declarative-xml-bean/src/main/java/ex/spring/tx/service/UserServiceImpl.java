package ex.spring.tx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ex.spring.tx.dao.UserDao;
import ex.spring.tx.model.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired private UserDao userDao;
	
	@Override
	public void writeUser(User user) {
		userDao.writeUser(user);
	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	@Override
	public User getUser(int userSeq) {
		return userDao.getUser(userSeq);
	}

}
