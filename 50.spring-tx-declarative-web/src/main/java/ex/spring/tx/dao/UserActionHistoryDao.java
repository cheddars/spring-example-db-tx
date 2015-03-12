package ex.spring.tx.dao;

import org.apache.ibatis.annotations.Param;

public interface UserActionHistoryDao {
	void writeHistory(
			@Param("user_seq") int user_seq, 
			@Param("action_type") String action_type, 
			@Param("action_desc") String action_desc);
}
