package ex.spring.tx.service;

import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ex.spring.tx.model.Article;

public interface ArticleService {
	@Transactional(propagation=Propagation.NEVER,  isolation=Isolation.READ_UNCOMMITTED ,readOnly=true)
	List<Article> list();
	Article view(String id);
	void deleteAll();

	@Transactional(propagation=Propagation.REQUIRED,  isolation=Isolation.READ_UNCOMMITTED ,readOnly=false)
	String write(Article article);
	
//	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Transactional(propagation=Propagation.NESTED)
	void delete(Article article, int user_seq);
}
