package cn.jie.dao;

import cn.jie.domain.User;

public interface UserDaoXml {

	public abstract void add(User user);
 
	//��½��֤   
	public abstract User find(String username, String password);

	//����ע���û��Ƿ������ݿ��д���
	public abstract boolean find(String username);

}