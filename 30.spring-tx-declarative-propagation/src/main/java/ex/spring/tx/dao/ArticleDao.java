package ex.spring.tx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Options;

import ex.spring.tx.model.Article;

public interface ArticleDao {
	@Options(useGeneratedKeys=true)
	int write(Article article);
	List<Article> list();
	Article view(String id);
	void deleteAll();
	void delete(String seq);
}