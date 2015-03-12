package ex.spring.tx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ex.spring.tx.dao.UserActionHistoryDao;

@Service
public class UserActionHistoryServiceImpl implements UserActionHistoryService {
	@Autowired private UserActionHistoryDao userActionHistoryDao;

	@Override
	public void writeHistory(int user_seq, String action_type, String action_desc) {
		userActionHistoryDao.writeHistory(user_seq, action_type, action_desc);
	}
}
