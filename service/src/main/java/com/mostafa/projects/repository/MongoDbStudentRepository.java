package com.mostafa.projects.repository;

import com.mostafa.projects.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MongoDbStudentRepository implements StudentRepository {
	private final MongoTemplate template;
	private final String STUDENT_ID_DB_COLUMN_NAME = "studentId";

	@Autowired
	public MongoDbStudentRepository(MongoTemplate template) {
		this.template = template;
	}
	@Override
	public Student getStudentById(String studentId) {
		List<Student> student = template.find(new Query(Criteria.where(STUDENT_ID_DB_COLUMN_NAME).is(studentId)),
				Student.class);
		if (student.isEmpty()) {
			System.out.println("No student found with ID " + studentId);
			return null;
		}
		if (student.size() > 1) {
			System.out.println("Multiple students found with ID " + studentId);
			return null;
		}
		return student.get(0);
	}

	@Override
	public void insertStudent(Student student) {
		template.save(student);
	}
}
