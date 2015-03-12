package ex.spring.tx.service;

import java.util.List;

import ex.spring.tx.model.Article;

public interface ArticleService {
	List<Article> list();
	Article view(String id);
	void deleteAll();
	void write(Article article);
}
