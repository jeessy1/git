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
	
	//登陆验证
	/* (non-Javadoc)
	 * @see cn.jie.dao.impl.UserDaoXml#find(java.lang.String, java.lang.String)
	 */
	@Override
	public User find(String username,String password){
		
		try {
			
			//调用xmlutils工具类，获取xml文档。
			Document document = XmlUtils.getDocument();
			
			//使用XPATH表达式查找用户名和密码相同的元素
			Element e = (Element) document.selectSingleNode("//user[@username='"+username+"' and @password='"+password+"']");
			if(e == null){
				return null;
			}
			//存在就创建一个user
			User user = new User();
			
			//获取日期
			String date = e.attributeValue("birthday");
			if(date==null || date.equals("")){
				user.setBirthday(null);
			}else{
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date birthday = sdf.parse(date);
				user.setBirthday(birthday);
			}
			
			//把获取的Element e的其它属性赋值给user
			user.setEmail(e.attributeValue("email"));
			user.setId(e.attributeValue("id"));
			user.setPassword(e.attributeValue("password"));
			user.setUsername(e.attributeValue("name"));
			
			//返回user
			return user;
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		
	}
	//查找注册用户是否在数据库中存在
	/* (non-Javadoc)
	 * @see cn.jie.dao.impl.UserDaoXml#find(java.lang.String)
	 */
	@Override
	public boolean find(String username){
		try {
			
			//调用xmlutils工具类，获取xml文档。
			Document document = XmlUtils.getDocument();
			
			//使用XPATH表达式查找用户名和密码相同的元素
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
