package ppjh.example.logexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LogexampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogexampleApplication.class, args);

		SpringApplication app = new SpringApplication(LogexampleApplication.class);
		app.setWebApplicationType(WebApplicationType.NONE);
		app.run(args);
	}

}
