package com.revature.cognizant;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.cognizant.domain.Department;
import com.revature.cognizant.service.EmployeeService;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.PropertyAccessor.FIELD;

@SpringBootApplication
public class CognizanttestApplication implements CommandLineRunner {
	
    @Value("${cognizant.importfile}")
    private String importFile;
	
	@Autowired
	private EmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(CognizanttestApplication.class, args);
	}
	

	@Override
	public void run(String... args) throws Exception {
		createEmployees (importFile);
		Long numOfEmployees = employeeService.total();
		
	}
	
	private void createEmployees(String fileToImport) throws IOException {
		EmployeeFromFile.read(fileToImport).forEach(importedEmployee ->
				employeeService.createEmployee(
						importedEmployee.getId(),
						importedEmployee.getFirstName(),
						importedEmployee.getLastName(),
						importedEmployee.getDepartment(),
						importedEmployee.getReportTo()));
		
	}
	
	//Helper class to import Emloyees.json
	
	private static class EmployeeFromFile {
		
		//fields
		private String  id, first_name, last_name, department, reportTo;
		
		//reader
		static List <EmployeeFromFile> read (String fileToImport) throws IOException {
			return new ObjectMapper().setVisibility(FIELD, ANY).
					readValue(new FileInputStream(fileToImport), new TypeReference<List<EmployeeFromFile>>() {});
			
		}
		
		protected EmployeeFromFile() {}
		
			Integer getId() {return Integer.parseInt(id);}
			String getFirstName() {return first_name;}
			String getLastName() {return last_name;}
			Department getDepartment() {return Department.valueOf(department);}
			Integer getReportTo() {return Integer.parseInt(reportTo);}
			
			
		}
		
	}


