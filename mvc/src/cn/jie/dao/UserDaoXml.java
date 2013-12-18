package cn.jie.dao;

import cn.jie.domain.User;

public interface UserDaoXml {

	public abstract void add(User user);
 
	//登陆验证   
	public abstract User find(String username, String password);

	//查找注册用户是否在数据库中存在
	public abstract boolean find(String username);

}