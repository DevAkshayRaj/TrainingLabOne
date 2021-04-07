package inherdemo;
public class BataShoeFactory extends ShoeFactory {
	private String bataName;
	
	public BataShoeFactory() {
	
	}

	public String getBataName() {
		return bataName;
	}

	public void setBataName(String bataName) {
		this.bataName = bataName;
	}

	@Override
	public String toString() {
		return "BataShoeFactory [bataName=" + bataName + "]";
	}
	
	
}
