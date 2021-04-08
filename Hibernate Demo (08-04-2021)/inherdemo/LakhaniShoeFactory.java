package inherdemo;

public class LakhaniShoeFactory  extends ShoeFactory {
	private String LakName;
	public LakhaniShoeFactory() {
		
	}
	public String getLakName() {
		return LakName;
	}
	public void setLakName(String lakName) {
		LakName = lakName;
	}
	@Override
	public String toString() {
		return "LakhaniShoeFactory [LakName=" + LakName + "]";
	}
	
	
}
