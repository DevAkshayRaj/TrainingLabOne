package hiberdemo;

import java.io.Serializable;

public class AirConditionerDto implements Cloneable, Serializable, Comparable<AirConditionerDto> {
	private int aid;
	private String company,type;
	private float price;
	private Description desc;
	
	public AirConditionerDto() {
		
	}
	
	public AirConditionerDto(int aid, String company, String type, float price, Description desc) {
		super();
		this.aid = aid;
		this.company = company;
		this.type = type;
		this.price = price;
		this.desc = desc;
	}
	
	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Description getDesc() {
		return desc;
	}

	public void setDesc(Description desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "AirConditionerDto [aid=" + aid + ", company=" + company + ", type=" + type + ", price=" + price
				+ ", desc=" + desc + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + aid;
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + Float.floatToIntBits(price);
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		AirConditionerDto other = (AirConditionerDto) obj;
		if (aid != other.aid)
			return false;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public int compareTo(AirConditionerDto o) {
		return this.company.compareTo(o.company);
	}
}
