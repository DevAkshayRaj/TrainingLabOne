package hiberdemo;

import java.io.Serializable;

public class Description implements Serializable{
	private String desc;

	public Description() {
		// TODO Auto-generated constructor stub
	}
	
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	@Override
	public String toString() {
		return this.desc;
	}
	
}
