package com.mostafa.projects.service;

import com.mostafa.projects.model.Student;
import com.mostafa.projects.repository.MongoDbStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentService {
	private final MongoDbStudentRepository studentRepository;

	@Autowired
	public StudentService(MongoDbStudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public Student getStudent(String studentId) {
		return studentRepository.getStudentById(studentId);
	}

	public void saveStudent(Student student) {
		studentRepository.insertStudent(student);
	}
}
