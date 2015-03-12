package ex.spring.tx.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration (locations={"/ctx.xml", "/spring-db-jdbc.xml"})
@Transactional
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=true)
public class UserPointServiceImplTest {
	@Autowired private UserPointService userPointService;
	
	@Test
	public void testUpdatePoint() {
		userPointService.updatePoint(1, 100);
	}
}
