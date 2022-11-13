package example.micronaut.entity;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.MappedProperty;
import io.micronaut.serde.annotation.Serdeable;

@MappedEntity(value = "employee")
@Serdeable
public class Employee {

	@Id
	@GeneratedValue(GeneratedValue.Type.IDENTITY)
	private Long id;
	
	@MappedProperty(value = "first_name")
	private String firstName;
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	
}
