package cn.jie.cookie;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class buyDb {

	private static Map<String,BuyBookClass> map = new LinkedHashMap<String, BuyBookClass>();
	static{
	map.put("1",new BuyBookClass("1","javaweb����1","��1","javaweb�����ĺ���1"));
	map.put("2",new BuyBookClass("2","javaweb����2","��2","javaweb�����ĺ���2"));
	map.put("3",new BuyBookClass("3","javaweb����3","��3","javaweb�����ĺ���3"));
	map.put("4",new BuyBookClass("4","javaweb����4","��4","javaweb�����ĺ���4"));
	map.put("5",new BuyBookClass("5","javaweb����5","��5","javaweb�����ĺ���5"));
	
	}
	public static Map<String,BuyBookClass> getAll(){
		return map;
	}

}


