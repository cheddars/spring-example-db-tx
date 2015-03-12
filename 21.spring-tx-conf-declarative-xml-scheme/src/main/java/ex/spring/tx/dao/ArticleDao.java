package ex.spring.tx.dao;

import java.util.List;

import ex.spring.tx.model.Article;

public interface ArticleDao {
	void write(Article article);
	List<Article> list();
	Article view(String id);
	void deleteAll();
	
}
