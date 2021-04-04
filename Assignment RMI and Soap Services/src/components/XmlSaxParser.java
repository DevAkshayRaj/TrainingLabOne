package components;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XmlSaxParser implements Extractable,Cloneable{
	public static XmlSaxParser obj=null;
	private XmlSaxParser() {
		
	}
	public static XmlSaxParser getObj() {
		if(obj==null) {
			obj=new XmlSaxParser();
		}
		return obj;
	}
	public XmlSaxParser getClone() throws Exception {
		return (XmlSaxParser)super.clone();
	}	
	@Override
	public ArrayList<ArrayList<String>> getDataFromXml(File fname) throws Exception {

		SAXParserFactory sxf = SAXParserFactory.newInstance();
		SAXParser sp = sxf.newSAXParser();

		MyXmlHandler1 h = new MyXmlHandler1();
		sp.parse(fname, h);
		HashMap<ArrayList<String>, ArrayList<ArrayList<String>>> hm = h.getTemp();
		ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
		ArrayList<String> heading = new ArrayList<String>();
		for (Map.Entry<ArrayList<String>, ArrayList<ArrayList<String>>> entry : hm.entrySet()) {
			//System.out.println(entry.getKey() + " => " + ": " + entry.getValue());
			data.add(entry.getKey());
			data.addAll(entry.getValue());
			heading.add(Integer.toString(data.indexOf(entry.getKey())));
		}

		// System.out.println(data);
		data.add(heading);
		return data;

	}

}

class MyXmlHandler1 extends DefaultHandler {
	
	ArrayList<String> temp = new ArrayList<String>();
	ArrayList<String> l = new ArrayList<String>();
	ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
	Stack<String> stack = new Stack<String>();
	HashMap<ArrayList<String>, ArrayList<ArrayList<String>>> hm = new LinkedHashMap<ArrayList<String>, ArrayList<ArrayList<String>>>();
	String buffer = null, flag = null;
	boolean flag2 = false;

	@Override
	public void startDocument() throws SAXException {

	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		stack.push(qName);
		// System.out.println("<"+qName+">");
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String s = new String(ch, start, length);
		buffer = s;
		flag2 = true;
		// System.out.println(localName);

	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// System.out.println("<\\"+qName+">");
		if (stack.size() == 2 && flag == null) {
			if (buffer != null) {
				ArrayList<String> tt = new ArrayList<String>();
				tt.add(qName);
				temp.add(buffer);
				data.add(temp);
				if (hm.get(tt) == null) {
					// data.add(temp);
					hm.put(tt, data);
				} else {
					data = hm.get(tt);
					data.add(temp);
				}
			}
			buffer = null;
			temp = new ArrayList<String>();
			data = new ArrayList<ArrayList<String>>();
			stack.pop();
			return;
		}
		if (flag != null) {
			if (stack.peek().equals(flag)) {
				stack.pop();
				// data.add(l);
				if (hm.get(l) == null) {
					data.add(temp);
					hm.put(l, data);
				} else {
					data = hm.get(l);
					data.add(temp);
				}
				data = new ArrayList<ArrayList<String>>();
				l = new ArrayList<String>();
				flag = null;
				temp = new ArrayList<String>();
				return;
			}
		}
		if (stack.peek().equals(qName)) {
			if (buffer != null)
				temp.add(buffer);
			if (buffer != null)
				l.add(stack.pop());
			buffer = null;
			if (flag == null && stack.size() != 0) {
				flag = stack.peek();
			}

		}
	}

	@Override
	public void endDocument() throws SAXException {

	}

	public HashMap<ArrayList<String>, ArrayList<ArrayList<String>>> getTemp() {
		return hm;
	}

	public ArrayList<ArrayList<String>> getData() {
		return data;
	}

}