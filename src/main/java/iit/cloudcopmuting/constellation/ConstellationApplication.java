package iit.cloudcopmuting.constellation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ConstellationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConstellationApplication.class, args);
	}

}
