package example.micronaut;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class Sample {

	 private final String name;

	    public Sample(String name) {
	        this.name = name;
	    }

	    public String getName() {
	        return name;
	    }
}
