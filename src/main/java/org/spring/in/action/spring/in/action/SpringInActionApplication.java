package org.spring.in.action.spring.in.action;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
//@EnableJpaAuditing
public class SpringInActionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringInActionApplication.class, args);
	}

}
