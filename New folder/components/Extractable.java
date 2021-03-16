package components;

import java.util.ArrayList;

public interface Extractable {
	public  ArrayList<ArrayList<String>> getDataFromXml(String filename) throws Exception;
}
