package com.EduVerse.eduVerse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.EduVerse")
@EntityScan(basePackages = {"com.EduVerse"})
@ComponentScan(basePackages ={"com.EduVerse"} )
@EnableJpaRepositories(basePackages = {"com.EduVerse"})
public class EduVerseApplication {

	public static void main(String[] args) {
		SpringApplication.run(EduVerseApplication.class, args);
	}

}
