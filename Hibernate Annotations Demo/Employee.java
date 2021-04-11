package annotationsdemo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EmployeeAnno")
public class Employee {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	//@Column(name = "NAME", nullable = false)
	private String name;
	//@Column(name = "JOININGDATE", nullable = false)
	//@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private LocalDate joiningDate;
	//@Column(name = "JOININGTIME", nullable = false)
	//@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalTime")
	private LocalTime joiningTime;
	
	//@Column(name = "JOININGDATETIME", nullable = false)
	//@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
	private LocalDateTime joiningDateTime;
	//@Column(name = "SALARY", nullable = false)
	private BigDecimal salary;
	
	//@Column(name = "SSN", unique=true, nullable = false)
	private String ssn;
	
	
	public BigDecimal getSalary() {
		return salary;
	}
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}
	public LocalTime getJoiningTime() {
		return joiningTime;
	}
	public void setJoiningTime(LocalTime joiningTime) {
		this.joiningTime = joiningTime;
	}
	public LocalDateTime getJoiningDateTime() {
		return joiningDateTime;
	}
	public void setJoiningDateTime(LocalDateTime joiningDateTime) {
		this.joiningDateTime = joiningDateTime;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", joiningDate=" + joiningDate + ", joiningTime=" + joiningTime
				+ ", joiningDateTime=" + joiningDateTime + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((joiningDate == null) ? 0 : joiningDate.hashCode());
		result = prime * result + ((joiningDateTime == null) ? 0 : joiningDateTime.hashCode());
		result = prime * result + ((joiningTime == null) ? 0 : joiningTime.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Employee other = (Employee) obj;
		if (id != other.id)
			return false;
		if (joiningDate == null) {
			if (other.joiningDate != null)
				return false;
		} else if (!joiningDate.equals(other.joiningDate))
			return false;
		if (joiningDateTime == null) {
			if (other.joiningDateTime != null)
				return false;
		} else if (!joiningDateTime.equals(other.joiningDateTime))
			return false;
		if (joiningTime == null) {
			if (other.joiningTime != null)
				return false;
		} else if (!joiningTime.equals(other.joiningTime))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	} 
	
	
	
	
}
