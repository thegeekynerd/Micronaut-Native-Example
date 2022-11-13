package example.micronaut.dto;

import javax.validation.constraints.NotBlank;

import io.micronaut.serde.annotation.Serdeable;
import lombok.Data;

@Data
@Serdeable
public class EmployeeDto {
	@NotBlank
	private String firstName; 
}
