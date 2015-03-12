package ex.spring.tx.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ex.spring.tx.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration (locations={"/ctx.xml"})
public class UserServiceImplTest {
	@Autowired private UserService userService;

	@Test
	public void testWriteUser() {
		User user = new User();
		user.setId("nezah");
		user.setEmail("nezah@solbox.com");
		user.setPwd("my-pwd");
		user.setName("Lee Hyun Soo");
		user.setPoint(0);
		userService.writeUser(user);
	}
	
	@Test
	@Transactional(propagation=Propagation.REQUIRED)
	public void testWriteUserWithTransaction() {
		User user = new User();
		user.setId("nezah");
		user.setEmail("nezah@solbox.com");
		user.setPwd("my-pwd");
		user.setName("Lee Hyun Soo");
		user.setPoint(0);
		userService.writeUser(user);
	}
}