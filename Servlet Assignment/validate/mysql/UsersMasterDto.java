package validate.mysql;

import java.io.Serializable;

public class UsersMasterDto implements Serializable {
	String name;
	String pwd;
	int flag;
	public synchronized final String getName() {
		return name;
	}
	public synchronized final void setName(String name) {
		this.name = name;
	}
	public synchronized final String getPwd() {
		return pwd;
	}
	public synchronized final void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public synchronized final int getFlag() {
		return flag;
	}
	public synchronized final void setFlag(int flag) {
		this.flag = flag;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + flag;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pwd == null) ? 0 : pwd.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsersMasterDto other = (UsersMasterDto) obj;
		if (flag != other.flag)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pwd == null) {
			if (other.pwd != null)
				return false;
		} else if (!pwd.equals(other.pwd))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "UsersMasterDto [name=" + name + ", pwd=" + pwd + ", flag=" + flag + "]";
	}
	
	
}
