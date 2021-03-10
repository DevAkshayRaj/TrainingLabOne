package day17;

import java.util.ListResourceBundle;
public class Dictionary_ta extends ListResourceBundle{
	Object obj[][]= {
			{"hello","vanakkam"},
			{"name","peyar"},
			{"time","neram"},
			{"water","thanniss"}
	};
@Override
protected Object[][] getContents() {
	// TODO Auto-generated method stub
	return obj;
}
}