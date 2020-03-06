package com.mostafa.projects.service;

import com.mostafa.projects.repository.MongoDbStudentRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentServiceConfig {
	@Bean
	public StudentService getStudentService(MongoDbStudentRepository repository) {
		return new StudentService(repository);
	}
}
