package ex.spring.tx.service;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ex.spring.tx.model.Article;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration (locations={"/ctx.xml"})
public class BoardServiceImplTest {
	@Autowired private ArticleService articleService;
	@Autowired private UserService userService;

	@Before
	public void setUp(){
		articleService.deleteAll();
	}

	@Test
	public void testWrite() {
		// Write First Article
		assertTrue(articleService.list().size() == 0);

		Article article = new Article(1, "title", "content", 2);
		article.setUser_seq(1);

		articleService.write(article);

		assertTrue(articleService.list().size() == 1);

		// Write Second Article but fail
		article = new Article(1, "fake", "content", 2);
		article.setUser_seq(1);

		articleService.write(article);

		assertTrue(articleService.list().size() == 1);
	}
}