package example.micronaut.repository;

import java.util.List;
import java.util.Optional;

import example.micronaut.entity.Employee;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

@JdbcRepository(dialect = Dialect.MYSQL)
public interface EmployeeRepos extends  CrudRepository<Employee, Long>{

	@Query("select * from employee where first_name = :firstName limit 1")
	Optional<Employee> findByName(String firstName);
	
	List<Employee> findAll();
}
