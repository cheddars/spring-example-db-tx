package ex.spring.tx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ex.spring.tx.dao.UserDao;
import ex.spring.tx.dao.UserPointHistoryDao;
import ex.spring.tx.model.User;

@Service("userPointServiceTarget")
public class UserPointServiceImpl implements UserPointService {
	@Autowired private UserDao userDao;
	@Autowired private UserPointHistoryDao userPointDao;
	
	@Override
	public void updatePoint(int user_seq, int amount) {
		User user = userDao.getUser(user_seq);
		userPointDao.writeHistory(user.getSeq(), user.getPoint(), amount);
		user.setPoint(user.getPoint() + amount);
		userDao.updateUser(user);
	}


}
