package cn.jie.service.impl;

import cn.jie.dao.UserDaoXml;
import cn.jie.dao.impl.UserDaoXmlImpl;
import cn.jie.domain.User;
import cn.jie.exception.UserExistException;
import cn.jie.service.BusinessService;
import cn.jie.utils.ServiceUtils;

//��WEB���ṩ���е�ҵ�����
public class BusinessServiceImpl implements BusinessService {
	
	
	private UserDaoXml dao = new UserDaoXmlImpl();
	
	
	//��web���ṩע�����
	/* (non-Javadoc)
	 * @see cn.jie.service.impl.BusinessService#register(cn.jie.domain.User)
	 */
	@Override
	public void register(User user) throws UserExistException{
		
		//���жϵ�ǰע����û��Ƿ�����
		Boolean b = dao.find(user.getUsername());
		if(b){
			throw new UserExistException();//����ע����û����ڣ����web���ױ����쳣�����û�һ���Ѻ���ʾ
		}else{
			
			//����ServiceUtils.md5�������������롣
			String passwordMd5 = ServiceUtils.md5(user.getPassword());
			
			//�Ѽ��ܺ�����븳ֵ��user�е�password
			user.setPassword(passwordMd5);
			
			//�Ѹ��ܺ��user��ӵ����ݿ���
			dao.add(user);
		}
	}   
	
	
	//��web�ṩ��½����
	/* (non-Javadoc)
	 * @see cn.jie.service.impl.BusinessService#login(java.lang.String, java.lang.String)
	 */
	@Override
	public User login(String username,String password){
		
		//�Ѵ�����password����
		password = ServiceUtils.md5(password);
		
		//����dao���fing�������ʺź�����
		return dao.find(username, password);
	}
}
