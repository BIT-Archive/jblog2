package jblog2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.jblog2.service.BlogService;
import com.cafe24.jblog2.service.UserService;
import com.cafe24.jblog2.vo.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/applicationContext.xml")
public class BlogTest {
	

	@Autowired
	private BlogService blogService;
	
	@Autowired
	private UserService userService;
	
	
	User user = new User();
	

	@Test
	@Transactional
	public void 블로그_생성_테스트() {
		User user = new User();

		user.setId("jihun");
		user.setName("홍지훈");
		user.setPassword("1234");
		user.setReg_date("0000-00-00");

		userService.join(user);
		blogService.create(user);
	}

}
