package com.mostafa.projects.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mostafa.projects.model.Student;
import com.mostafa.projects.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/find/{studentId}", method= RequestMethod.GET)
    public Student getStudent(@PathVariable String studentId){
        return studentService.getStudent(studentId);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity saveStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
        return new ResponseEntity("Student saved successfully", HttpStatus.OK);
    }

}
