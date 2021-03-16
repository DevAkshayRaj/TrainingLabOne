package consignmentTracker;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InputDataReader implements Cloneable{
	static InputData input=null;
	static InputBuilder ipbuild=null;
	private static InputDataReader obj=null;
	private InputDataReader() {
		
	}
	public static InputDataReader getObj() {
		if(obj==null) {
			obj=new InputDataReader();
		}
		return obj;
	}
	
	public InputDataReader getClone() throws Exception{
		return(InputDataReader)super.clone();
	}
	
	public InputData getInput() throws Exception{
		ipbuild=InputBuilder.getObj().getClone();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String ip=null;
		System.out.print("Please Enter The Starting Date in (yyyy-mm-dd) Format : ");
		ip=br.readLine();
		ipbuild=ipbuild.setStartDate(ip);
		System.out.println();
		
		System.out.print("Please Enter The Starting Time in (hrs:mins:secs) Format : ");
		ip=br.readLine();
		ipbuild=ipbuild.setStartTime(ip);
		System.out.println();
		
		System.out.print("Please Enter The Place from Where the Shipment Starts : ");
		ip=br.readLine();
		ipbuild=ipbuild.setOriginPlace(ip);
		System.out.println();
		
		System.out.print("Please Enter The Place to which the Shipment Must Be delivered: ");
		ip=br.readLine();
		ipbuild=ipbuild.setDestinationPlace(ip);
		System.out.println();
		
		System.out.print("Please Enter the Average Travel Speed : ");
		ip=br.readLine();
		ipbuild=ipbuild.setSpeed(Double.parseDouble(ip));
		System.out.println();
		
		System.out.print("Please Enter the Average Distance : ");
		ip=br.readLine();
		ipbuild=ipbuild.setDistance(Double.parseDouble(ip));
		System.out.println();
		
		System.out.print("Please Enter the Average Rest and Break Time Taken per day During the Travel in (hrs:mins:secs) Format : ");
		ip=br.readLine();
		ipbuild=ipbuild.setFreeTime(ip);
		System.out.println();
		
		input=ipbuild.getObject();
		
		return input;
	
	}
	
	
}

/*
2021-01-01
08:36:35
Coimbatore
Chennai
60 
499.78
05:30:00*/