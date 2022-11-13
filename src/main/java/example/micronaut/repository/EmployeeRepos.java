package example.micronaut.repository;

import example.micronaut.entity.Employee;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

@JdbcRepository(dialect = Dialect.MYSQL)
public interface EmployeeRepos extends  CrudRepository<Employee, Long>{

}
