package day24;
import java.util.*;

import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebService;
@WebService(endpointInterface = "twentyfour.ComplexService")
@HandlerChain(file = "twentyfour/handler-chain.xml")
public class ComplexServiceImpl implements ComplexService {
	public ComplexServiceImpl() {
		emp=new Employee(1,"ramu",1000);
		list.add(emp);
		emp=new Employee(2,"somu",2000);
		list.add(emp);
	}
	Employee emp;
	List<Employee> list=new ArrayList<>();
	@WebMethod
	@Override
	public void setEmployee(Employee emp) {
		System.out.println("new employee added...:"+emp.getEid()+":"+emp.getEname());
		this.emp=emp;
		list.add(emp);
		
	}
	@WebMethod
	@Override
	public void setAllEmployee(List<Employee> list) {
		System.out.println("all employees are added...."+list);
		this.list=list;
		
	}
	@WebMethod
	@Override
	public Employee getEmployee(String eid) {
		Iterator<Employee> iter=list.iterator();
		int eidnum=Integer.parseInt(eid);
		while(iter.hasNext()) {
			Employee e=iter.next();
			if(e.getEid()==eidnum) {
				return e;
			}
			else {
				return null;
			}
		}
		return null;
	}
	@WebMethod
	@Override
	public List<Employee> getAllEmployees() {
		return this.list;
	}
	
}
