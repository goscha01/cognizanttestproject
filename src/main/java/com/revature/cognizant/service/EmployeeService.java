package com.revature.cognizant.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.cognizant.domain.Department;
import com.revature.cognizant.domain.Employee;
import com.revature.cognizant.repo.EmployeeRepository;

@Service
public class EmployeeService {
	private EmployeeRepository employeeRepository;
	

	@Autowired
	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	
	
	public Employee createEmployee( Integer id, String firstName, String lastName, Department department, Integer reportTo) {
		
		return employeeRepository.findById(id).orElse(employeeRepository.save(new Employee (id, firstName,  lastName,  department,  reportTo)));
	}
	
	
	public Iterable<Employee> lookup() {
		return employeeRepository.findAll();
	}
	
	public long total () {
		return employeeRepository.count();
	}


}
