package components;

import java.io.File;
import java.util.ArrayList;

public interface Extractable {
	public  ArrayList<ArrayList<String>> getDataFromXml(File filename) throws Exception;
}
