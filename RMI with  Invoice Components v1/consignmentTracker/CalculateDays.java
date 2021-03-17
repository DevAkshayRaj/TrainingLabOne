package consignmentTracker;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class CalculateDays {
	int no_of_days,no_of_hours;
	LocalTime lt;
	LocalDate ld;
	InputData ip;	
	public CalculateDays(InputData ip) {
		super();
		this.ip = ip;
	}

	public void calcDays( ) {
		double dist=ip.getDistance();
		double speed=ip.getSpeed();
		double time=dist/speed;
		no_of_days=(int)(time/24);
		no_of_hours=(int)(time%24);
	}
	
	public void calcRestTime() {
		int temp=0,restHours=0,restMins=0;
		if(ip.getFreeTime().getHour()!=0)
			restHours=no_of_days*ip.getFreeTime().getHour();
		if(ip.getFreeTime().getMinute()!=0)
			restMins=no_of_days*ip.getFreeTime().getMinute();
		if(restMins>60) {
			no_of_hours+=restMins/60;
		}
		if(restHours>=24) {
			no_of_days+=(restHours/24);
			temp=restHours%24;
		}
		no_of_hours+=temp;
		if(no_of_hours>=24) {
			no_of_days+=(no_of_hours/24);
			no_of_hours=no_of_hours%24;
		}
		ld=ip.getStartDate().plus(no_of_days,ChronoUnit.DAYS);
		if(no_of_hours<10) {
			lt=LocalTime.parse("0"+Integer.toString(no_of_hours)+":30:30");
		}else {
			lt=LocalTime.parse(Integer.toString(no_of_hours)+":30:30");
		}

	}
	
	public void getDeliverTime(){
		this.calcDays();
		this.calcRestTime();
		
		System.out.println("The Approximate Delivery Date is : "+this.ld);
		System.out.println("The Approximate Delivery Time is : "+this.lt);
	}
	
	public int getDaysLeft() {
		LocalDate temp=LocalDate.now();
		int daysLeft=0;
		int d1=temp.getDayOfYear();
		int d2=this.ld.getDayOfYear();
		if(d2>d1) {
			daysLeft=d2-d1;
		}
		return daysLeft;
	}
	
	public int getTimeLeft() {
		LocalTime temp=LocalTime.now();
		int timeLeft=12;
		int d1=temp.getHour();
		int d2=this.lt.getHour();
		if(d2>d1) {
			timeLeft=d2-d1;
		}else {
			timeLeft+=Math.abs(d2-d1);
		}
		return timeLeft;
	}
	
	public void printInput() {
		String[] s=ip.toString().split(",");
		int count=0;
		for(String temp:s) {
			count++;
			System.out.print(temp.strip()+"    ");
			if(count==4) {
				break;
			}
		}
		System.out.println();
	}
	
	public void printOutput() {
		System.out.println("The Approximate Time Left for the user to receive the parcel is "+getDaysLeft()+" days and "+getTimeLeft()+" Hours");
	}
	
}
