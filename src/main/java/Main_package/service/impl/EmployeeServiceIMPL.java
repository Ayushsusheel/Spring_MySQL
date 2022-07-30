package Main_package.service.impl;

import java.util.List;
//import java.util.Optional;

import org.springframework.stereotype.Service;

import Main_package.exception.ResourceNotFoundException;
import Main_package.model.Employee;
import Main_package.repository.EmployeeRepository;
import Main_package.service.EmployeeService;


@Service
public class EmployeeServiceIMPL implements EmployeeService{

	private EmployeeRepository emprepo;
	
	
	//@Autowired  ----- no need to add only 1 constructor is present
	public EmployeeServiceIMPL(EmployeeRepository emprepo) {
		super();
		this.emprepo = emprepo;
	}


	
	
	
	@Override
	public Employee savedetails(Employee obj) 
	{
		 return emprepo.save(obj);
	}





	@Override
	public List<Employee> getAllDetails() 
	{
		
		return emprepo.findAll();
	}





	@Override
	public Employee getdetailsbyID(Integer id) //yha pe long hta ke Integer krde
	{
		
		return emprepo.findById(id).orElseThrow(); //()-> new ResourceNotFoundException("Employee","Id",id)

	}





	@Override
	public Employee update(Employee obj, Integer id) 
	{
		//1st check given id exist in DB or not
		
		Employee exist=emprepo.findById(id).orElseThrow();
		
		
		//now set
		exist.setFirstName(obj.getFirstName());
		exist.setLastName(obj.getLastName());
		exist.setEmail(obj.getEmail());
		
		
		//we need to save in DB
		
		emprepo.save(exist);
		
		
		return exist ;
		
	}





	@Override
	public void deletedetails(Integer id)
	{
		
		//first check id exist or not
		
		
		emprepo.findById(id).orElseThrow();
		
		
		
		//now delete
		emprepo.deleteById(id);
		
		
	}





	





	

} 






