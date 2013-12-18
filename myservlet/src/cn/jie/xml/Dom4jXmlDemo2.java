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
		
		//��ȡ���ڵ�
		Element root = document.getRootElement();
		
//		find(root);
//		add(root,document);
//		add2(root,document);
//		add3(root,document);
		del(root,document);

		
	}
	//ɾ��,  ����ָ����λ��
	private static void del(Element root,Document document) throws DocumentException, IOException {
		//����Ԫ��elementsΪ���Ԫ�أ�������0λ����

		//��ȡroot�µ�������Ԫ��
	    List listRoot = root.elements();
	    //��ȡ�ڶ���root�е�Ԫ�ء�
	    Element book =  (Element) listRoot.get(1);
	    
	    
	    //�г��ڶ���Ԫ���е�������Ԫ�أ�������list�����С�
	    Element del = (Element) book.elements("�ۼ�");
	    book.remove(del);
	    		
	    		
	    //Ư���ĸ�ʽ�����,���ø�ʽ���ΪUTF-8
	    OutputFormat format = OutputFormat.createPrettyPrint();
	    format.setEncoding("UTF-8");
	    		
	    XMLWriter writer = new XMLWriter(new FileOutputStream("src/xml.xml"),format);
	    writer.write(document);
	    writer.close();
	      

	}
	
	
	
	//���3,  ����ָ����λ��
	private static void add3(Element root,Document document) throws DocumentException, IOException {
		//����Ԫ��elementsΪ���Ԫ�أ�������0λ����

		//��ȡroot�µ�������Ԫ��
	    List listRoot = root.elements();
	    //��ȡ�ڶ���root�е�Ԫ�ء�
	    Element book =  (Element) listRoot.get(1);
	    
	    //�г��ڶ���Ԫ���е�������Ԫ�أ�������list�����С�
	    List list = book.elements();
	    Element price = DocumentHelper.createElement("�ۼ�");
	    price.setText("93");
	    list.add(2,price);
	    		
	    		
	    //Ư���ĸ�ʽ�����,���ø�ʽ���ΪUTF-8
	    OutputFormat format = OutputFormat.createPrettyPrint();
	    format.setEncoding("UTF-8");
	    		
	    XMLWriter writer = new XMLWriter(new FileOutputStream("src/xml.xml"),format);
	    writer.write(document);
	    writer.close();
	      

	}
	
	
	//���2
	private static void add2(Element root,Document document) throws DocumentException, IOException {
		//����Ԫ��elementsΪ���Ԫ�أ�������0λ����

		Element book =  (Element) root.elements("��").get(1);
		book.addElement("�ۼ�").addAttribute("namm", "11").setText("92");
		
		//Ư���ĸ�ʽ�����,���ø�ʽ���ΪUTF-8
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");
		
		XMLWriter writer = new XMLWriter(new FileOutputStream("src/xml.xml"),format);
		writer.write(document);
		writer.close();

	}
	
	//���
	private static void add(Element root,Document document) throws DocumentException, IOException {
		//����Ԫ��elementsΪ���Ԫ�أ�������0λ����

		Element book =  (Element) root.elements("��").get(1);
		book.addElement("�ۼ�").setText("91");
		
		
		XMLWriter writer = new XMLWriter(new OutputStreamWriter(new FileOutputStream("src/xml.xml"),"UTF-8"));
		writer.write(document);
		writer.close();

	}
	
	
	
	//����
	private static void find(Element root) {
		
		//����Ԫ��elementsΪ���Ԫ�أ�������0λ����
		Element book =  (Element) root.elements("��").get(0);
		
		//��book������ȡ������Ԫ���е�ֵ��
		String value = book.element("����").getText();
		
		//��ȡ"����"��"name"������ֵ
		String name = book.element("����").attributeValue("name");
		
		//��ӡ
        System.out.println("value="+value + "     name=" + name);
	}
}