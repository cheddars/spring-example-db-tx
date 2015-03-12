package ex.spring.tx.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import ex.spring.tx.dao.ArticleDao;
import ex.spring.tx.model.Article;

@Service
public class BoardServiceImpl implements ArticleService {
	private static Logger log = LoggerFactory.getLogger(BoardServiceImpl.class);
	@Autowired private ArticleDao articleDao;
	@Autowired private UserPointService userPointService;
	@Autowired private UserActionHistoryService userActionHistoryService;
	@Autowired private TransactionTemplate transactionTemplate;
	
	@Override
	public List<Article> list() {
		log.info("boardService.list()");
		return articleDao.list();
	}

	@Override
	public void write(final Article article) {
		log.info("boardService.write()");
		String action = "write bbs article";
		
		try{
			transactionTemplate.execute(new TransactionCallback<Integer>(){
				@Override
				public Integer doInTransaction(TransactionStatus status) {
					articleDao.write(article);
	
					userPointService.updatePoint(article.getUser_seq(), 10);
					
					if("fake".equals(article.getTitle())){
						throw new RuntimeException("Can't not write article with title ["+article.getTitle()+"]");
					}
					return null;
				}
				
			});
		}catch(Exception e){
			log.error(e.getMessage(), e);
			action += " but failed with " + e.getMessage();
		}
		
		userActionHistoryService.writeHistory(article.getUser_seq(), "WB", action);
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
	

	
}
