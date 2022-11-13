package example.micronaut;

import example.micronaut.entity.Employee;
import example.micronaut.repository.EmployeeRepos;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller
public class ControllerSample {
	
	EmployeeRepos employeeRepos;
	
	public ControllerSample(EmployeeRepos empR) {
		this.employeeRepos = empR;
	}

	@Get("/sample")
	public Sample getSample() {
		return new Sample("My Name");
	}
	
	@Get("/employee/{id}")
	public Employee getEmployee(Long id) {
		
		return employeeRepos.findById(id).orElse(new Employee());
	}
}
