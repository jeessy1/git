package junit.test;

import java.util.Date;

import org.jboss.weld.ejb.spi.BusinessInterfaceDescriptor;
import org.junit.Test;

import cn.jie.domain.User;
import cn.jie.exception.UserExistException;
import cn.jie.service.BusinessService;
import cn.jie.service.impl.BusinessServiceImpl;

public class ServiceTest {
	@Test
	public void testRegister() throws UserExistException{
		User user = new User();
		user.setBirthday(new Date());
		user.setEmail("af@dfdf.com");
		user.setId("11dfsdd11");
		user.setPassword("123456");
		user.setUsername("chenjie");
		
		BusinessService bsi = new BusinessServiceImpl();
		bsi.register(user);
	}
	
	@Test
	public void testLogin() throws UserExistException{
		BusinessService bsi = new BusinessServiceImpl();
		User user = bsi.login("chenjie","123456");
		System.out.println(user);
	}
}
