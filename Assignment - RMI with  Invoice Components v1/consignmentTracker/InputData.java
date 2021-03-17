package consignmentTracker;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class InputData implements Cloneable,Serializable{
	private static InputData obj=null;
	private InputData() {
	}
	synchronized public static InputData getObj() {
		if(obj==null) {
			obj=new InputData();
		}
		return obj;
	}
	synchronized public InputData getClone() throws Exception{
		return (InputData)super.clone();
	}
	private LocalDate startDate;
	private LocalTime startTime;
	private String originPlace;
	private String destinationPlace;
	private double distance;
	private double speed;
	private LocalTime freeTime;
	
	public void setInputData(LocalDate startDate, LocalTime startTime, String originPlace, String destinationPlace,
			double distance, double speed, LocalTime freeTime) {
		this.startDate = startDate;
		this.startTime = startTime;
		this.originPlace = originPlace;
		this.destinationPlace = destinationPlace;
		this.distance = distance;
		this.speed = speed;
		this.freeTime = freeTime;
	}
	@Override
	public String toString() {
		return "startDate=" + startDate + ", startTime=" + startTime + ", originPlace=" + originPlace
				+ ", destinationPlace=" + destinationPlace + ", distance=" + distance + ", speed=" + speed
				+ ", freeTime=" + freeTime ;
	}
	public synchronized final LocalDate getStartDate() {
		return startDate;
	}
	public synchronized final LocalTime getStartTime() {
		return startTime;
	}
	public synchronized final String getOriginPlace() {
		return originPlace;
	}
	public synchronized final String getDestinationPlace() {
		return destinationPlace;
	}
	public synchronized final double getDistance() {
		return distance;
	}
	public synchronized final double getSpeed() {
		return speed;
	}
	public synchronized final LocalTime getFreeTime() {
		return freeTime;
	}
	
	
	
}
