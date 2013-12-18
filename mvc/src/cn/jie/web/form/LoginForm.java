package cn.jie.web.form;

import java.util.HashMap;
import java.util.Map;

import cn.jie.domain.User;
import cn.jie.service.BusinessService;
import cn.jie.service.impl.BusinessServiceImpl;

public class LoginForm {
	private String username;
	private String password;
	
	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	Map<String,String> map = new HashMap<String,String>();
	
	//�ж��û����������Ƿ���ͬ
	public boolean validate(){
		
		BusinessService bs=	new BusinessServiceImpl();
		boolean tag =true;
		if(username==null && username.trim().equals("")){
			map.put("username", "�ʺŲ���Ϊ��");
			tag = false;
		}
		if(password==null && password.trim().equals("")){
			map.put("password", "���벻��Ϊ��");
			tag = false;
		}
		if(bs.login(username, password)==null){
			map.put("password", "�ʺŻ��������");
			tag = false;
		}
		
		
	return tag;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
