package repo;

import org.springframework.data.repository.CrudRepository;

import com.revature.cognizant.domain.Employee;

public interface EmployeeRepository extends CrudRepository <Employee, Integer> {

}
