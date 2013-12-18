package cn.jie.web.form;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

public class RegisterForm {

	private String username;
	private String password;
	private String password2;
	private String email;
	private String birthday;
	
	
	private Map<String,String> errors = new HashMap<String,String>();
	
	public Map<String,String> getErrors() {
		return errors;
	}

	public void setErrors(Map<String,String> errors) {
		this.errors = errors;
	}

	//用户名不能为空，3-8个字母
	//密码不能为空，3-8个数字
	//确认密码不为空，并一致
	//电子邮箱不为空，并且是一个合法邮箱
	//生日可以为空，不为空时必须为正确的日期
	public boolean validate(){
		
		boolean isok = true;
		
		if(this.username==null || this.username.trim().equals("")){
			errors.put("username", "用户不为空");
			isok=false;
		}else{
			if(!this.username.matches("[a-zA-Z]{3,8}")){
			errors.put("username", "用户名必须是3-8个字母");
			isok=false;
			}
		}
		
		
		if(this.password==null || this.password.trim().equals("")){
			errors.put("password", "密码不为空");
			isok=false;
		}else{
			if(!this.password.matches("\\d{3,8}")){
			errors.put("password", "密码必须是3-8个数字");
			isok=false;
			}
		}
		
		
		if(this.password2==null || this.password2.trim().equals("")){
			errors.put("password2", "确认密码不为空");
			isok=false;
		}else{
			if(!this.password2.equals(password)){
			errors.put("password2", "两次密码要相同");
			isok=false;
			}
		}
		
		
		if(this.email==null || this.email.trim().equals("")){
			errors.put("email", "邮箱不为空");
			isok=false;
		}else{
			if(!this.email.matches("\\w+@\\w+(\\.\\w+)+")){
			errors.put("email", "邮箱格式不正确");
			isok=false;
			}
		}
		
		if(this.birthday!=null && this.birthday.trim().equals("")){
			try{
			DateLocaleConverter dlc = new DateLocaleConverter(); //把日期转化，日期不对就抛异常
			dlc.convert(this.birthday,"yyyy-MM-dd");
			}catch (Exception e){
				errors.put("birthday", "生日不对");
				isok=false;
			}

		}
		
		
		return isok;
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
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	
}
