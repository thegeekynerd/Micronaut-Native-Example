package example.micronaut;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller
public class ControllerSample {

	@Get("/sample")
	public Sample getSample() {
		return new Sample("My Name");
	}
}
