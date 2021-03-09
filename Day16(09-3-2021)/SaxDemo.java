package day16;


import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxDemo {
	public static void main(String[] args) throws Exception{
		SAXParserFactory sxf=SAXParserFactory.newInstance();
		SAXParser sp=sxf.newSAXParser();
		
		sp.parse("Students.xml", new MyXmlHandler());
	}

}

class MyXmlHandler extends DefaultHandler{
	@Override
	public void startDocument() throws SAXException {
		System.out.println("Parsing by SAX started !");
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		//System.out.println("start : " + qName);
	}
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String s=new String(ch,start,length);
		System.out.print("Char : "+s+"   ");
		System.out.println();
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println("End: " + qName+" "+localName);
	}
	
	@Override
	public void endDocument() throws SAXException {
		System.out.println("End of Parsing By Sax");
		super.endDocument();
	}
	
	
}