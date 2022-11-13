package example.micronaut;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import example.micronaut.dto.EmployeeDto;
import example.micronaut.entity.Employee;
import example.micronaut.repository.EmployeeRepos;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;

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

	@Get("/employee/all")
	public List<Employee> getAll() {
		return employeeRepos.findAll();
	}

	@Put("/employee")
	public MutableHttpResponse<Object> putEmployee(@Body @Valid EmployeeDto employee) {

		Optional<Employee> employeeOp = employeeRepos.findByName(employee.getFirstName());

		if (employeeOp.isPresent())
			return HttpResponse.badRequest("Already present");

		Employee newEmployee = new Employee();
		newEmployee.setFirstName(employee.getFirstName());

		return HttpResponse.created(employeeRepos.save(newEmployee));

	}

	@Post("/employee/{id}")
	public MutableHttpResponse<Object> updateEmployee(Long id, @Body @Valid EmployeeDto emp) {

		Optional<Employee> empOp = employeeRepos.findById(id);

		if (empOp.isEmpty())
			return HttpResponse.badRequest("Invalid Id");

		Employee empEntity = empOp.get();
		empEntity.setFirstName(emp.getFirstName());

		return HttpResponse.accepted().body(employeeRepos.update(empEntity));

	}

	@Delete("/employee/{id}")
	public MutableHttpResponse<Object> deleteEmployee(Long id) {

		Optional<Employee> empOp = employeeRepos.findById(id);

		if (empOp.isEmpty())
			return HttpResponse.badRequest("Invalid Id");
		employeeRepos.delete(empOp.get());
		return HttpResponse.accepted().body("Deleted");
	}
}
