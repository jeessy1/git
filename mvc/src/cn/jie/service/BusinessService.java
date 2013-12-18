package cn.jie.service;

import cn.jie.domain.User;
import cn.jie.exception.UserExistException;

public interface BusinessService {

	//对web层提供注册服务
	public abstract void register(User user) throws UserExistException;

	//对web提供登陆服务
	public abstract User login(String username, String password);

}