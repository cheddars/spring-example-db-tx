package ex.spring.tx.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ex.spring.tx.model.Article;

public interface BatchService {
	@Transactional(propagation=Propagation.REQUIRED)
	void deleteArticleBatch(List<Article> articles, int userSeq);
}
