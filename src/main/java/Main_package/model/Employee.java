package Main_package.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
//import lombok.Getter;
//import lombok.Setter;

@Data //----internally getter,setter,hashcode,tostring provide krta h 

//@Getter
//@Setter
@Entity
@Table(name="employee_management_table")

public class Employee 
{

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="first_name",nullable=false)
	private String firstName;
	
	
	@Column(name="last_name",nullable=false)
	private String lastName;
	
	@Column(name="email",nullable=false)
	private String email;
	
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
}
