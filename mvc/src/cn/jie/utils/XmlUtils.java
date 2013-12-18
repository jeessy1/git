package cn.jie.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class XmlUtils {
	
	private static String filepath;
	static{ //静态代码块只执行一次
		filepath = XmlUtils.class.getClassLoader().getResource("/user.xml").getPath();
	}
	
	public static Document getDocument() throws DocumentException{

		SAXReader reader = new SAXReader();
		return reader.read(new File(filepath));
		
	}
	
	
	public static void write2Xml(Document document) throws IOException{
		
	    //漂亮的格式输出器,设置格式输出为UTF-8
	    OutputFormat format = OutputFormat.createPrettyPrint();
	    format.setEncoding("UTF-8");
	    		
	    XMLWriter writer = new XMLWriter(new FileOutputStream(filepath),format);
	    writer.write(document);
	    writer.close();
	}

}
