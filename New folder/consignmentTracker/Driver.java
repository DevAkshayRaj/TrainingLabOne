package consignmentTracker;

public class Driver {
	public static void main(String[] args) throws Exception{
		
		InputData ip=InputDataReader.getObj().getClone().getInput();
		CalculateDays cd=new CalculateDays(ip);
		cd.printInput();
		System.out.println();
		cd.getDeliverTime();
		System.out.println();
		cd.printInput();
		
	}

}
