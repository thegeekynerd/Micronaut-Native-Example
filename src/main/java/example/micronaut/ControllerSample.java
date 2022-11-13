package example.micronaut;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller
public class ControllerSample {

	@Get
	public Sample getSample() {
		return new Sample("My Name");
	}
}
