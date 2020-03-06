package com.mostafa.projects.repository;

import com.mostafa.projects.model.Student;

public interface StudentRepository {
	public Student getStudentById(String studentId);
	public void insertStudent(Student student);
}
