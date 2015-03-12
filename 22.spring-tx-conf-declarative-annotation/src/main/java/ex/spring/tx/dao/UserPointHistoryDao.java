package ex.spring.tx.dao;

import org.apache.ibatis.annotations.Param;

public interface UserPointHistoryDao {
	void writeHistory(@Param("user_seq") int user_seq, 
			@Param("initial_point") int initial_point, 
			@Param("amount") int amount);
}
