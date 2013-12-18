package cn.jie.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;

import cn.jie.dao.UserDaoXml;
import cn.jie.domain.User;
import cn.jie.utils.XmlUtils;

public class UserDaoXmlImpl implements UserDaoXml {
	
	
	/* (non-Javadoc)
	 * @see cn.jie.dao.impl.UserDaoXml#add(cn.jie.domain.User)
	 */
	@Override
	public void add(User user){
		try {
			Document document = XmlUtils.getDocument();
			Element root = document.getRootElement();
			
//			Element user_tag = root.addElement("user");
//			Iterator user_tag_att = user_tag.attributeIterator();
//			for(int i = 0;user_tag_att.hasNext();){
//				Element user_tag = (Element) it.next();
//			}
			Element user_tag= root.addElement("user")
			.addAttribute("id", user.getId())
			.addAttribute("username", user.getUsername())
			.addAttribute("password", user.getPassword())
			.addAttribute("email", user.getEmail())
			.addAttribute("birthday", user.getBirthday()==null?"":user.getBirthday().toLocaleString());
			
			XmlUtils.write2Xml(document);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	//��½��֤
	/* (non-Javadoc)
	 * @see cn.jie.dao.impl.UserDaoXml#find(java.lang.String, java.lang.String)
	 */
	@Override
	public User find(String username,String password){
		
		try {
			
			//����xmlutils�����࣬��ȡxml�ĵ���
			Document document = XmlUtils.getDocument();
			
			//ʹ��XPATH���ʽ�����û�����������ͬ��Ԫ��
			Element e = (Element) document.selectSingleNode("//user[@username='"+username+"' and @password='"+password+"']");
			if(e == null){
				return null;
			}
			//���ھʹ���һ��user
			User user = new User();
			
			//��ȡ����
			String date = e.attributeValue("birthday");
			if(date==null || date.equals("")){
				user.setBirthday(null);
			}else{
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date birthday = sdf.parse(date);
				user.setBirthday(birthday);
			}
			
			//�ѻ�ȡ��Element e���������Ը�ֵ��user
			user.setEmail(e.attributeValue("email"));
			user.setId(e.attributeValue("id"));
			user.setPassword(e.attributeValue("password"));
			user.setUsername(e.attributeValue("name"));
			
			//����user
			return user;
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		
	}
	//����ע���û��Ƿ������ݿ��д���
	/* (non-Javadoc)
	 * @see cn.jie.dao.impl.UserDaoXml#find(java.lang.String)
	 */
	@Override
	public boolean find(String username){
		try {
			
			//����xmlutils�����࣬��ȡxml�ĵ���
			Document document = XmlUtils.getDocument();
			
			//ʹ��XPATH���ʽ�����û�����������ͬ��Ԫ��
			Element e = (Element) document.selectSingleNode("//user[@username='"+username+"']");
			if(e == null){
				return false;
			}else{
				return true;
			}
			} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
