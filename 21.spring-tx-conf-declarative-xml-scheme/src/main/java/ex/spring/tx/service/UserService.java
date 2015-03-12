package ex.spring.tx.service;

import ex.spring.tx.model.User;

public interface UserService {
	void writeUser(User user);
	void updateUser(User user);
	User getUser(int userSeq);
}
