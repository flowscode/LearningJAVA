package com.flowcode.crudApp;

import com.flowcode.crudApp.model.Employee;
import com.flowcode.crudApp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudAppApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CrudAppApplication.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception {
//		Employee employee1 = new Employee();
//		employee1.setFirstName("Joshua");
//		employee1.setLastName("Dawkins");
//		employee1.setEmail("Joshua.Dawkins@gmail.com");
//		employeeRepository.save(employee1);
//
//		Employee employee2 = new Employee();
//		employee2.setFirstName("Robert");
//		employee2.setLastName("Wilson");
//		employee2.setEmail("Robert.Wilson@gmail.com");
//		employeeRepository.save(employee2);
	}
}
