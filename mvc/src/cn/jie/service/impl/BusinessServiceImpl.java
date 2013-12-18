package cn.jie.service.impl;

import cn.jie.dao.UserDaoXml;
import cn.jie.dao.impl.UserDaoXmlImpl;
import cn.jie.domain.User;
import cn.jie.exception.UserExistException;
import cn.jie.service.BusinessService;
import cn.jie.utils.ServiceUtils;

//对WEB层提供所有的业务服务
public class BusinessServiceImpl implements BusinessService {
	
	
	private UserDaoXml dao = new UserDaoXmlImpl();
	
	
	//对web层提供注册服务
	/* (non-Javadoc)
	 * @see cn.jie.service.impl.BusinessService#register(cn.jie.domain.User)
	 */
	@Override
	public void register(User user) throws UserExistException{
		
		//先判断当前注册的用户是否在在
		Boolean b = dao.find(user.getUsername());
		if(b){
			throw new UserExistException();//发现注册的用户在在，则给web层抛编译异常，给用户一个友好提示
		}else{
			
			//调用ServiceUtils.md5方法，加密密码。
			String passwordMd5 = ServiceUtils.md5(user.getPassword());
			
			//把加密后的密码赋值给user中的password
			user.setPassword(passwordMd5);
			
			//把改密后的user添加到数据库中
			dao.add(user);
		}
	}   
	
	
	//对web提供登陆服务
	/* (non-Javadoc)
	 * @see cn.jie.service.impl.BusinessService#login(java.lang.String, java.lang.String)
	 */
	@Override
	public User login(String username,String password){
		
		//把传来的password加密
		password = ServiceUtils.md5(password);
		
		//调用dao层的fing方法查帐号和密码
		return dao.find(username, password);
	}
}
