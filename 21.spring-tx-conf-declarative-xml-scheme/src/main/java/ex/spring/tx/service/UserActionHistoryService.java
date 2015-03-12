package ex.spring.tx.service;

public interface UserActionHistoryService {
	void writeHistory(int user_seq, String action_type, String action_desc);
}
