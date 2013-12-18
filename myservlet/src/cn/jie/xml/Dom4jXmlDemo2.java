package cn.jie.xml;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.xml.sax.DocumentHandler;

public class Dom4jXmlDemo2 {
	public static void main(String[] args) throws Exception{
		
		Dom4jDemo1 dom2jdemo1 = new Dom4jDemo1();
		Document document = dom2jdemo1.parse();
		
		//获取根节点
		Element root = document.getRootElement();
		
//		find(root);
//		add(root,document);
//		add2(root,document);
//		add3(root,document);
		del(root,document);

		
	}
	//删除,  存在指定的位置
	private static void del(Element root,Document document) throws DocumentException, IOException {
		//查找元素elements为书的元素，而且在0位置上

		//获取root下的所有子元素
	    List listRoot = root.elements();
	    //获取第二个root中的元素。
	    Element book =  (Element) listRoot.get(1);
	    
	    
	    //列出第二个元素中的所有子元素，并存在list集合中。
	    Element del = (Element) book.elements("售价");
	    book.remove(del);
	    		
	    		
	    //漂亮的格式输出器,设置格式输出为UTF-8
	    OutputFormat format = OutputFormat.createPrettyPrint();
	    format.setEncoding("UTF-8");
	    		
	    XMLWriter writer = new XMLWriter(new FileOutputStream("src/xml.xml"),format);
	    writer.write(document);
	    writer.close();
	      

	}
	
	
	
	//添加3,  存在指定的位置
	private static void add3(Element root,Document document) throws DocumentException, IOException {
		//查找元素elements为书的元素，而且在0位置上

		//获取root下的所有子元素
	    List listRoot = root.elements();
	    //获取第二个root中的元素。
	    Element book =  (Element) listRoot.get(1);
	    
	    //列出第二个元素中的所有子元素，并存在list集合中。
	    List list = book.elements();
	    Element price = DocumentHelper.createElement("售价");
	    price.setText("93");
	    list.add(2,price);
	    		
	    		
	    //漂亮的格式输出器,设置格式输出为UTF-8
	    OutputFormat format = OutputFormat.createPrettyPrint();
	    format.setEncoding("UTF-8");
	    		
	    XMLWriter writer = new XMLWriter(new FileOutputStream("src/xml.xml"),format);
	    writer.write(document);
	    writer.close();
	      

	}
	
	
	//添加2
	private static void add2(Element root,Document document) throws DocumentException, IOException {
		//查找元素elements为书的元素，而且在0位置上

		Element book =  (Element) root.elements("书").get(1);
		book.addElement("售价").addAttribute("namm", "11").setText("92");
		
		//漂亮的格式输出器,设置格式输出为UTF-8
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");
		
		XMLWriter writer = new XMLWriter(new FileOutputStream("src/xml.xml"),format);
		writer.write(document);
		writer.close();

	}
	
	//添加
	private static void add(Element root,Document document) throws DocumentException, IOException {
		//查找元素elements为书的元素，而且在0位置上

		Element book =  (Element) root.elements("书").get(1);
		book.addElement("售价").setText("91");
		
		
		XMLWriter writer = new XMLWriter(new OutputStreamWriter(new FileOutputStream("src/xml.xml"),"UTF-8"));
		writer.write(document);
		writer.close();

	}
	
	
	
	//查找
	private static void find(Element root) {
		
		//查找元素elements为书的元素，而且在0位置上
		Element book =  (Element) root.elements("书").get(0);
		
		//在book对象中取出作者元素中的值。
		String value = book.element("作者").getText();
		
		//获取"作者"中"name"的属性值
		String name = book.element("作者").attributeValue("name");
		
		//打印
        System.out.println("value="+value + "     name=" + name);
	}
}