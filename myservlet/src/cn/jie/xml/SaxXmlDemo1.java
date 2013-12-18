package cn.jie.xml;


import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

public class SaxXmlDemo1 {
	public static void main(String[] args) throws Exception{
		SAXParserFactory saxPF = SAXParserFactory.newInstance();
		SAXParser saxP = saxPF.newSAXParser();
		XMLReader xmlR = saxP.getXMLReader();
		xmlR.setContentHandler(new SaxXmlContentHandler());
		
		xmlR.parse(new InputSource("src/xml.xml"));
	}

}

