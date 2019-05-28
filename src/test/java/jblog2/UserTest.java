package jblog2;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cafe24.jblog2.service.UserService;
import com.cafe24.jblog2.vo.User;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/applicationContext.xml")
public class UserTest {
	
	@Autowired
	UserService userService;
	
	@Test
	public void 회원리스트_불러오기() {
		
		assertNotNull(userService.getList());
	}

	
	@Test
	@Rollback(true)
	public void 회원가입_테스트() {
		try {
			User user = new User();

			user.setId("Test id111");
			user.setName("홍지훈");
			user.setPassword("1234");
			user.setReg_date("0000-00-00");

			userService.join(user);
		}catch(Exception e) {
			e.printStackTrace();
		}

		
		assertNotNull(userService.getList());
	}
	
	
	

}
