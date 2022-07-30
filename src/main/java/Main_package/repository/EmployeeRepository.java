package Main_package.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Main_package.model.Employee;


//@Repository
//@Transactional  no need to add this jpa internally provides this

public interface EmployeeRepository extends JpaRepository<Employee,Integer>  //yha pe Integer h long nai
{

	
}
