package Main_package.service;

import Main_package.model.Employee;
//import Main_package.model.EmployeeDTO;
import java.util.List;
//import java.util.Optional;

public interface EmployeeService 
{

	Employee savedetails(Employee employee);
	
	
	List<Employee> getAllDetails();
	
	
	Employee getdetailsbyID(Integer id); //Integer h id long nai
	
	Employee update(Employee obj,Integer id);
	
	void deletedetails(Integer id);
	
}
