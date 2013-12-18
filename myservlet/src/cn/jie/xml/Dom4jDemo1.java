package cn.jie.xml;

import java.net.URL;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

public class Dom4jDemo1 {

    public Document parse() throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read("src/xml.xml");
        
        
        return document;
    }
}