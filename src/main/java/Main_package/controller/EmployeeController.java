package Main_package.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Main_package.model.Employee;
import Main_package.service.EmployeeService;

@RestController
/*@RequestMapping(value="/api") */ @RequestMapping("/employees")
public class EmployeeController 
{
    @Autowired
	private EmployeeService empservice;
	
//	public EmployeeController(EmployeeService empservice) {
//		super();
//		this.empservice = empservice;
//	}

	
	//building rest api CREATE
	//@PostMapping(value="/employees",consumes=MediaType.APPLICATION_JSON_VALUE)  //----postmapping se json object aaya h usko  map krna h employee obj se therefore use request body
	
    
    
    
    
    @PostMapping(value="/add")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee)
	{	
	   
		return new ResponseEntity<>(empservice.savedetails(employee),HttpStatus.OK); //ok--200 
    
	}
    
    
    //get all details 2nd rest api
    
    @GetMapping(value="/details")
    public List<Employee> getall()
    {
    	return empservice.getAllDetails();
    }
    
    
    //get details by ID 3rd rest api
    
    @GetMapping("/details/{id}")
    public ResponseEntity<Employee> getdetailsbyID(@PathVariable("id") Integer ID) //Intger krde long ki jgh
    {
    	return new ResponseEntity<Employee>(empservice.getdetailsbyID(ID),HttpStatus.OK);
//    	return null;
    }
    
    
    //UPDATE 4th API
	
    @PutMapping("/details/{id}")
    public ResponseEntity<Employee> update(@PathVariable ("id")Integer id,@RequestBody Employee obj)
    {
    
    	return new ResponseEntity<Employee>(empservice.update(obj, id),HttpStatus.OK);
    	
    }
	
    
    
    //5th DELETE API
    @DeleteMapping("/details/{id}")
    public ResponseEntity<String> delete(@PathVariable ("id") Integer id)//ResponseEntity represents an HTTP response, including headers, body, and status
    {
    
    	//delete from DB
    	empservice.deletedetails(id);
    	
    	return new ResponseEntity<String>("DELETED RECORD SUCCESSFULLY.....",HttpStatus.OK);
    	
    	
    	
    	
    }
    
    
}
