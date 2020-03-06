package com.mostafa.projects.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.PersistenceConstructor;

@ApiModel
public class Student {

	@PersistenceConstructor
	public Student(String studentId, String name, int grade) {
		this.studentId = studentId;
		this.name = name;
		this.grade = grade;
	}

	private String studentId;
	private String name;
	private int grade;

	@ApiModelProperty(name = "studentId")
	public String getStudentId() {
		return studentId;
	}

	@ApiModelProperty(name = "name")
	public String getName() {
		return name;
	}

	@ApiModelProperty(name = "grade")
	public int getGrade() {
		return grade;
	}

	public static class Builder {
		private String studentId;
		private String name;
		private int grade;

		public Builder(String studentId, String name, int grade) {
			this.studentId = studentId;
			this.name = name;
			this.grade = grade;
		}

		public Builder withStudentId(String studentId) {
			this.studentId = studentId;
			return this;
		}

		public Builder withName(String name) {
			this.name = name;
			return this;
		}

		public Builder withGrade(int grade) {
			this.grade = grade;
			return this;
		}

		public Student build() {
			return new Student(this);
		}
	}

	public Student(Builder builder) {
		this.studentId = builder.studentId;
		this.name = builder.name;
		this.grade = builder.grade;
	}
}
