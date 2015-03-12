package ex.spring.tx.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ex.spring.tx.model.User;

public interface UserService {

	@Transactional(propagation=Propagation.NEVER)
	void writeUser(User user);

	@Transactional(propagation=Propagation.MANDATORY)
	void updateUser(User user);

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	User getUser(int userSeq);

}
