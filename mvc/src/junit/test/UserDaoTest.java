package junit.test;

import java.util.Date;

import org.junit.Test;

import cn.jie.dao.UserDaoXml;
import cn.jie.dao.impl.UserDaoXmlImpl;
import cn.jie.domain.User;

public class UserDaoTest {
	@Test 
	public void testAdd(){
		User user = new User();
		user.setBirthday(new Date());
		user.setEmail("af@dfdf.com");
		user.setId("11dfsdd11");
		user.setPassword("1dsfs23");
		user.setUsername("afdsfsda");
		
		UserDaoXml userDaoXmlImpl = new  UserDaoXmlImpl();
		userDaoXmlImpl.add(user);
	}
	
	@Test 
	public void find(){
		UserDaoXml userDaoXmlImpl = new  UserDaoXmlImpl();
		userDaoXmlImpl.find("aa","123");
	}
	
	@Test 
	public void findByUsername(){
		UserDaoXml userDaoXmlImpl = new  UserDaoXmlImpl();
		userDaoXmlImpl.find("aa");
	}
	
}
