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

	//�û�������Ϊ�գ�3-8����ĸ
	//���벻��Ϊ�գ�3-8������
	//ȷ�����벻Ϊ�գ���һ��
	//�������䲻Ϊ�գ�������һ���Ϸ�����
	//���տ���Ϊ�գ���Ϊ��ʱ����Ϊ��ȷ������
	public boolean validate(){
		
		boolean isok = true;
		
		if(this.username==null || this.username.trim().equals("")){
			errors.put("username", "�û���Ϊ��");
			isok=false;
		}else{
			if(!this.username.matches("[a-zA-Z]{3,8}")){
			errors.put("username", "�û���������3-8����ĸ");
			isok=false;
			}
		}
		
		
		if(this.password==null || this.password.trim().equals("")){
			errors.put("password", "���벻Ϊ��");
			isok=false;
		}else{
			if(!this.password.matches("\\d{3,8}")){
			errors.put("password", "���������3-8������");
			isok=false;
			}
		}
		
		
		if(this.password2==null || this.password2.trim().equals("")){
			errors.put("password2", "ȷ�����벻Ϊ��");
			isok=false;
		}else{
			if(!this.password2.equals(password)){
			errors.put("password2", "��������Ҫ��ͬ");
			isok=false;
			}
		}
		
		
		if(this.email==null || this.email.trim().equals("")){
			errors.put("email", "���䲻Ϊ��");
			isok=false;
		}else{
			if(!this.email.matches("\\w+@\\w+(\\.\\w+)+")){
			errors.put("email", "�����ʽ����ȷ");
			isok=false;
			}
		}
		
		if(this.birthday!=null && this.birthday.trim().equals("")){
			try{
			DateLocaleConverter dlc = new DateLocaleConverter(); //������ת�������ڲ��Ծ����쳣
			dlc.convert(this.birthday,"yyyy-MM-dd");
			}catch (Exception e){
				errors.put("birthday", "���ղ���");
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
