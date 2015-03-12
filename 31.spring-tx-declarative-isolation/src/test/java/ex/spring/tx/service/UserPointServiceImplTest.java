package ex.spring.tx.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration (locations={"/ctx.xml"})
public class UserPointServiceImplTest {
	@Autowired private UserPointService userPointService;
	
	@Test
	public void testUpdatePoint() {
		userPointService.updatePoint(1, 100);
	}
}
