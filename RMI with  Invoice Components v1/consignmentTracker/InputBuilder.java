package consignmentTracker;

import java.time.LocalDate;
import java.time.LocalTime;

public class InputBuilder implements Cloneable{
	private static InputBuilder obj=null;
	private InputBuilder() {

	}
	
	synchronized public static InputBuilder getObj() {
		if(obj==null) {
			obj=new InputBuilder();
		}
		return obj;
	}
	
	synchronized public InputBuilder getClone() throws Exception{
		return (InputBuilder)super.clone();
	}
	
	private LocalDate startDate;
	private LocalTime startTime;
	private String originPlace;
	private String destinationPlace;
	private double distance;
	private double speed;
	private LocalTime freeTime;
	
	public final InputBuilder setStartDate(String startDate) {
		this.startDate = LocalDate.parse(startDate);
		return this;
	}
	public final InputBuilder setStartTime(String startTime) {
		this.startTime = LocalTime.parse(startTime);
		return this;
	}
	public final InputBuilder setOriginPlace(String originPlace) {
		this.originPlace = originPlace;
		return this;
	}
	public final InputBuilder setDestinationPlace(String destinationPlace) {
		this.destinationPlace = destinationPlace;
		return this;
	}
	public final InputBuilder setDistance(double distance) {
		this.distance = distance;
		return this;
	}
	public final InputBuilder setSpeed(double speed) {
		this.speed = speed;
		return this;
	}
	public final InputBuilder setFreeTime(String freeTime) {
		this.freeTime = LocalTime.parse(freeTime);
		return this;
	}
	
	public InputData getObject() throws Exception{
		
		InputData ip=InputData.getObj().getClone();
		
		ip.setInputData(this.startDate,this.startTime,this.originPlace,this.destinationPlace,
				this.distance,this.speed,this.freeTime);
		return ip;
	}
	
}
