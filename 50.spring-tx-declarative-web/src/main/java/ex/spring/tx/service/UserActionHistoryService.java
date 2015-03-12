package ex.spring.tx.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface UserActionHistoryService {
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	void writeHistory(int user_seq, String action_type, String action_desc);
}
