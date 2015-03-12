package ex.spring.tx.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import ex.spring.tx.model.Article;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration (locations={"/ctx.xml", "/spring-db-jdbc.xml"})
@Transactional
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=true)
public class BatchServiceImplTest {
	@Autowired private BatchService batchService;
	@Autowired private ArticleService articleService;
	
	@Test
	public void testDeleteArticleBatch() {
		List<Article> articles = new ArrayList<Article>();
		articles.add(new Article(articleService.write(new Article(1, "title1", "content1", 1))));
		articles.add(new Article(articleService.write(new Article(1, "title2", "content2", 1))));
		Article a = new Article(articleService.write(new Article(1, "title3", "content3", 1)));
		a.setTitle("title3");
		articles.add(a);
//		int userSeq = 1;
		int userSeq = 10;
		batchService.deleteArticleBatch(articles , userSeq);
	}

}
