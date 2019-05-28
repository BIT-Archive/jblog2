package jblog2;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.jblog2.service.UserService;
import com.cafe24.jblog2.vo.User;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/applicationContext.xml")
public class UserTest {
	
	@Autowired
	private UserService userService;
	
	
	@Test
	public void 회원리스트_불러오기() {
		
		assertNotNull(userService.getList());
	}

	
	@Test
	@Transactional
	public void 회원가입_테스트() {
		try {
			User user = new User();

			user.setId("jihun");
			user.setName("홍지훈");
			user.setPassword("1234");
			user.setReg_date("0000-00-00");

			userService.join(user);
			
			assertNotNull(userService.LoginAuth(user));
		}catch(Exception e) {
			e.printStackTrace();
		}

		
		
	}
	
	

	@Test
	public void 로그인_테스트_성공() {
		try {
			User user = new User();

			user.setId("홍지훈");
			user.setPassword("1234");
			
			assertNotNull(userService.LoginAuth(user));
			// 수정 필요
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void 로그인_테스트_실패() {
		try {
			User user = new User();

			user.setName("홍지훈");
			user.setPassword("654123165");

			assertNull(userService.LoginAuth(user));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}


}
