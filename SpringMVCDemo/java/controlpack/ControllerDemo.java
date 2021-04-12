package controlpack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Service;
@Controller
@RequestMapping("hello")
public class ControllerDemo {
	@Autowired
	public BusinessLogic businesslogic;
	
	public BusinessLogic getBusinesslogic() {
		return businesslogic;
	}
	public void setBusinesslogic(BusinessLogic businesslogic) {
		this.businesslogic = businesslogic;
	}
	@RequestMapping(value="hello1",method = RequestMethod.GET)
	public void hello() {
		System.out.println("hello called");
	}
	@RequestMapping(value="hello2",method=RequestMethod.GET)
	public String hello1() {
		return "Hello";
	}
	@RequestMapping(value="business",method=RequestMethod.GET)
	public void doLogic() {
		System.out.println("Logic Called!");
		businesslogic.doBusiness();
	}
	
	@RequestMapping(value="getdata",method =RequestMethod.GET)
	public ModelAndView mandvdemo() {
		ModelAndView mandv=new ModelAndView();
		mandv.setViewName("Data");
		Employee emp=new Employee();
		emp.setEid(1);
		emp.setEname("Akshay Raj");
		mandv.addObject("emp", emp);
		mandv.addObject("some","blah balah blah !");
		return mandv;
	}
}

@Component
class BusinessLogic{
	@Autowired
	private ServiceLayer servicelayer;

	public ServiceLayer getServicelayer() {
		return servicelayer;
	}

	public void setServicelayer(ServiceLayer servicelayer) {
		this.servicelayer = servicelayer;
	}

	public void doBusiness() {
		System.out.println("Business Layer Called");
		servicelayer.doService();
	}
	
}
@Service
class ServiceLayer{
	@Autowired
	private Employee employee;
	public void doService() {
		System.out.println("ServiceLayerCalled");
		employee.setEid(1);
		employee.setEname("Akshay Raj");
		employee.doDao(employee);
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
}

@Repository
class Employee{
	private int eid;
	private String ename;
	public void doDao(Employee a) {
		System.out.println("Repo Layer Called");
		System.out.println(a);
	}
	
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + "]";
	}
	
	
}
