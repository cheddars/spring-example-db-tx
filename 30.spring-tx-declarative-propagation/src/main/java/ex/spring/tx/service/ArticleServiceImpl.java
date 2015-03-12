package ex.spring.tx.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ex.spring.tx.dao.ArticleDao;
import ex.spring.tx.model.Article;

@Service("articleServiceTarget")
public class ArticleServiceImpl implements ArticleService {
	private static Logger log = LoggerFactory.getLogger(ArticleServiceImpl.class);
	@Autowired private ArticleDao articleDao;
	@Autowired private UserPointService userPointService;
	@Autowired private UserActionHistoryService userActionHistoryService;
	@Autowired private PointBankService pointBankService;

	@Override
	public List<Article> list() {
		log.info("boardService.list()");
		return articleDao.list();
	}

	@Override
	public String write(Article article) {
		log.info("boardService.write()");
		String action = "write bbs article";
		
		userActionHistoryService.writeHistory(article.getUser_seq(), "WB", action);
		
		int seq = articleDao.write(article);
		System.out.println("SEQ : " + seq);
		userPointService.updatePoint(article.getUser_seq(), 10);
						
		if("fake".equals(article.getTitle())){
			throw new RuntimeException("Can't not write article with title ["+article.getTitle()+"]");
		}	
		return String.valueOf(seq);
	}

	@Override
	public Article view(String id) {
		log.info("boardService.view()");
		return articleDao.view(id);
	}

	@Override
	public void deleteAll() {
		log.info("boardService.deleteAll()");
		articleDao.deleteAll();
	}

	@Override
	public void delete(Article article, int user_seq) {
		userActionHistoryService.writeHistory(user_seq, "BD", "batch detelte " + article.toString());
		if("title3".equals(article.getTitle())){
			throw new RuntimeException("title3 can't not be deleted");
		}

		articleDao.delete(article.getSeq());	
	}	
}