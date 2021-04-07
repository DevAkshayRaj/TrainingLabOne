package inherdemo;

import java.io.Serializable;

public class ShoeFactory implements Serializable,Cloneable{
	private int sid;
	private String pname;
	public ShoeFactory() {
		
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	@Override
	public String toString() {
		return "ShoeFactory [sid=" + sid + ", pname=" + pname + "]";
	}
	
}
