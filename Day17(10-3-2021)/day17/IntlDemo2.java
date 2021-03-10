package day17;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
public class IntlDemo2 {
public static void main(String[] args) {
	NumberFormat nf=NumberFormat.getCurrencyInstance(new Locale("en","US"));
	
	int i=2_0_0_0_0_3_42;
	
	System.out.println(String.format("%s",nf.format(i)));
	
	
	DateFormat df=DateFormat.getDateInstance(DateFormat.SHORT,new Locale("en","US"));
	
	
	Date date=new Date();
	
	System.out.println(df.format(date));
	
	
	DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("d-MMM-YYYY",new Locale("en","US"));
	String currentDate=LocalDate.now().format(dateTimeFormatter);
	
	System.out.println(currentDate);
	
	
}
}