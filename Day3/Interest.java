package second_session;

//A Java Program to calculate the interest as given.
public class Interest {
	private float principle;

	public float getPrinciple() {
		return principle;
	}

	public void setPrinciple(int principle) {
		this.principle = principle;
	}
	public void increaseByPercentage(float percentage) {
		double temp=(float)(principle*(float)(percentage));
		principle+=temp;
	}
	public void increaseByValue(int value) {
		principle+=value;
	}
	public void decreaseByPercentage(int percentage) {
		double temp=(float)(principle*(float)(percentage/100));
		principle-=temp;
		
	}
	public void decresaeByValue(int value) {
		principle-=value;
	}
	public static void main(String[] args) {
	 
		Interest i=new Interest();
		i.setPrinciple(14000);
		i.increaseByPercentage(0.40f);
		//System.out.println(i.getPrinciple());
		i.decresaeByValue(1500);
		i.increaseByPercentage(0.12f);
		System.out.println("The Principle after theree years is : "+i.getPrinciple());
	}

}
