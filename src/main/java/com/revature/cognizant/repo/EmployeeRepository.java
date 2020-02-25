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


import com.revature.cognizant.domain.Department;
import com.revature.cognizant.domain.Employee;


@RepositoryRestResource(collectionResourceRel = "employees", path = "employees")
public interface EmployeeRepository extends CrudRepository <Employee, Integer>  {

	Optional<Employee> findByLastName(String lastName);
	
	List<Employee> findAll ();

	@Override
	default void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	default void delete(Employee entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	default void deleteAll() {
		// TODO Auto-generated method stub
		
	}
	
		

	


	
	
	
}
