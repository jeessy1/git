package cn.jie.utils;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

public class WebUtils {
	
	//把request中的参数封装到bean中
	public static<T> T request2Bean(HttpServletRequest request,Class<T> clazz){
		
		
		try {
			T bean = clazz.newInstance();
			Enumeration e = request.getParameterNames();
			while(e.hasMoreElements()){
				String name = (String) e.nextElement();
				String value = request.getParameter(name);
				BeanUtils.setProperty(bean, name, value);
			}
			return bean;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	//BEAN拷贝
	public static void copyBean(Object src,Object dest){
		//注册日期转换器
		ConvertUtils.register(new Converter(){
			public Object convert(Class type,Object value){
			if (value==null){
				return null;
			}
			
			String str = (String)value;
			if(str.trim().equals("")){
				return null;
			}
			
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			try {
				return df.parse(str);
			} catch (ParseException e) {
				throw new RuntimeException();
				}
			}
		}, Date.class);
		
		try {
			BeanUtils.copyProperties(dest, src);
		} catch (Exception e) {
			throw new RuntimeException();
		}

	}
	
	//产生全球唯一的ID
	public static String generateID(){
		return UUID.randomUUID().toString();
	}
}
