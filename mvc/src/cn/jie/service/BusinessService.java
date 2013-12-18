package cn.jie.service;

import cn.jie.domain.User;
import cn.jie.exception.UserExistException;

public interface BusinessService {

	//��web���ṩע�����
	public abstract void register(User user) throws UserExistException;

	//��web�ṩ��½����
	public abstract User login(String username, String password);

}