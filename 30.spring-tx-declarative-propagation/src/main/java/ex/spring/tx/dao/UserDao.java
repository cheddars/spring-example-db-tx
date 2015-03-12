package ex.spring.tx.dao;

import ex.spring.tx.model.User;

public interface UserDao {
	User getUser(int userSeq);
	void updateUser(User user);
	void writeUser(User user);
}
