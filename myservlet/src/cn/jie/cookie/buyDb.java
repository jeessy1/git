package cn.jie.cookie;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class buyDb {

	private static Map<String,BuyBookClass> map = new LinkedHashMap<String, BuyBookClass>();
	static{
	map.put("1",new BuyBookClass("1","javaweb开发1","陈1","javaweb开发的好书1"));
	map.put("2",new BuyBookClass("2","javaweb开发2","陈2","javaweb开发的好书2"));
	map.put("3",new BuyBookClass("3","javaweb开发3","陈3","javaweb开发的好书3"));
	map.put("4",new BuyBookClass("4","javaweb开发4","陈4","javaweb开发的好书4"));
	map.put("5",new BuyBookClass("5","javaweb开发5","陈5","javaweb开发的好书5"));
	
	}
	public static Map<String,BuyBookClass> getAll(){
		return map;
	}

}


