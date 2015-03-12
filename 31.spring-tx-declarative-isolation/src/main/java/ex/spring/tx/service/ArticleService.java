package ex.spring.tx.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ex.spring.tx.model.Article;

public interface ArticleService {
	List<Article> list();
	
	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED)
	Article view(String id);
	void deleteAll();

	@Transactional(propagation=Propagation.REQUIRED, readOnly=false, rollbackFor={SQLException.class})
	String write(Article article);
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false, rollbackFor={SQLException.class})
	String update(Article article);
	
//	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Transactional(propagation=Propagation.NESTED)
	void delete(Article article, int user_seq);
}
