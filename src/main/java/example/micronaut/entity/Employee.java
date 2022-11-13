package example.micronaut.entity;

import javax.persistence.Column;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.serde.annotation.Serdeable;
import lombok.Data;

@MappedEntity(value = "employee")
@Serdeable
@Data
public class Employee {

	@Id
	@GeneratedValue(GeneratedValue.Type.IDENTITY)
	private Long id;
	
	@Column(name = "first_name")
	private String firstName;
}
