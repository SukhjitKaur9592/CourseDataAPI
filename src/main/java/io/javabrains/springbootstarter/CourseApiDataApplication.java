package io.javabrains.springbootstarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CourseApiDataApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(CourseApiDataApplication.class, args);
	}
	@CrossOrigin("http://localhost:4200")
	@RequestMapping("/")
	public String printStartUpMessage()
	{
		return "Application has started";
	}
	
}
