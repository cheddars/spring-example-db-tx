package ex.spring.tx.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


public interface UserPointService {
	@Transactional(propagation=Propagation.MANDATORY)
	void updatePoint(int user_seq, int amount);
}
