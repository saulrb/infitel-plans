package com.infytel.plans.infitelplans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.infytel.plans.infitelplans.*")
public class InfitelPlansApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfitelPlansApplication.class, args);
	}

}
