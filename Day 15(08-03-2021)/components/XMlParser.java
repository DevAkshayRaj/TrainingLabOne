package components;

import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import org.w3c.dom.Document;

public class XMlParser implements Cloneable{
	public static XMlParser obj=null;
	private XMlParser() {
		
	}
	public static XMlParser getObj() {
		if(obj==null) {
			obj=new XMlParser();
		}
		return obj;
	}
	public XMlParser getClone() throws Exception {
		return (XMlParser)super.clone();
	}
	public  ArrayList<ArrayList<String>> getDataFromXml(String filename) throws Exception {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setIgnoringElementContentWhitespace(true);
		dbf.setValidating(true);

		DocumentBuilder db = dbf.newDocumentBuilder();

		Document doc = db.parse(filename);
		ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
		ArrayList<String> title = new ArrayList<String>();
		Node n = doc.getDocumentElement().getFirstChild();
		int count = 0;
		while (n != null) {
			NodeList nl = n.getChildNodes();
			if (nl.getLength() != count) {
				count = nl.getLength();
				for (int i = 0; i < nl.getLength(); i++) {
					title.add(nl.item(i).getNodeName());
				}
				data.add(title);
				title = new ArrayList<String>();
			}
			for (int i = 0; i < nl.getLength(); i++) {
				title.add(nl.item(i).getFirstChild().getNodeValue());
			}
			data.add(title);
			title = new ArrayList<String>();
			n = n.getNextSibling();
		}
		return data;

	}

}
