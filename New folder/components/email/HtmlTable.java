package components.email;

import java.util.ArrayList;
import java.util.StringJoiner;

//String tempa="<table><tr><th>Company</th><th>Contact</th><th>Country</th></tr><tr><td>Alfreds Futterkiste</td><td>Maria Anders</td><td>Germany</td>";


public class HtmlTable {
	public String toHtmlTable(ArrayList<ArrayList<String>> data,int h[]) {
		String op="<table><tr><th>";
		StringJoiner td=new StringJoiner("","<td>","</td>");
		StringJoiner th=new StringJoiner("","<th>","</th>");
		StringJoiner tr=new StringJoiner("","<tr>","</tr>");
		for(int i=0;i<data.size();i++) {
			
		}
		return op;
	}
}
