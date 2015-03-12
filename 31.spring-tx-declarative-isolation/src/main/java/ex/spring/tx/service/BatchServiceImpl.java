package ex.spring.tx.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ex.spring.tx.model.Article;

@Service
public class BatchServiceImpl implements BatchService {
	private static Logger log = LoggerFactory.getLogger(ArticleServiceImpl.class);
	@Autowired private ArticleService articleService;
	@Autowired private UserPointService userPointService;
	@Autowired private UserActionHistoryService userActionHistoryService;
	@Autowired private PointBankService pointBankService;
	
	@Override
	public void deleteArticleBatch(List<Article> articles, int userSeq) {
		userActionHistoryService.writeHistory(userSeq, "BD", "batch detelte " + articles.toString());
		
		int returnedPoints = 0;
		
		for(Article article : articles){
			try{
				articleService.delete(article, userSeq);
				returnedPoints -= 10;
			}catch(Exception e){
				log.error(e.getMessage(), e);
			}
		}
		
		pointBankService.update(returnedPoints);
		if(userSeq == 10){
			throw new RuntimeException("batch rollback!!");
		}
	}

}
