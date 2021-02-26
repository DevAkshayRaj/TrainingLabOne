package day9_lab;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Field;



class Months{
	public int January=1,Februry=2,march=3,apirl=4,may=5,june=6,july=7,august=8,september=9,october=10,november=11,december=12;
}


public class Seasons {
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String ip=br.readLine();
		Months months=new Months();
		Class c=months.getClass();
		Field f=c.getField(ip);
		
		if((Integer)f.get(months)==2||(Integer)f.get(months)==3) {
			System.out.println(ip +" comes under Spring Season ");
		}
		else if((Integer)f.get(months)>=4&&(Integer)f.get(months)<=6) {
			System.out.println(ip +" comes under Summer Season ");
		}
		else if((Integer)f.get(months)>=7&&(Integer)f.get(months)<=9) {
			System.out.println(ip +"c omes under Summer Season ");
		}
		else if((Integer)f.get(months)==12||(Integer)f.get(months)==1) {
			System.out.println(ip +" comes under Winter Season ");
		}
		else {
			System.out.println(ip +" comes under Autumn Season ");
		}
		
	}

}
