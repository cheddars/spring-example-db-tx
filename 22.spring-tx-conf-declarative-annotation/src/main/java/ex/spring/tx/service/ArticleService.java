package ex.spring.tx.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ex.spring.tx.model.Article;


public interface ArticleService {
	List<Article> list();
	Article view(String id);
	void deleteAll();
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	void write(Article article);
}
