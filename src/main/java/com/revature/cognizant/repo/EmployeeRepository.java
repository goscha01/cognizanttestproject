package com.revature.cognizant.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.revature.cognizant.domain.Department;
import com.revature.cognizant.domain.Employee;


@Repository
public interface EmployeeRepository extends CrudRepository <Employee, Integer>  {

	Optional<Employee> findByLastName(String lastName);
	
	List<Employee> findAll ();

	

	
	
	
}
