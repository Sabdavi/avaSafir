package com.avasafir.learning.controller;

import com.avasafir.learning.domain.Student;
import com.avasafir.learning.mapper.StudentMapper;
import com.avasafir.learning.model.StudentDto;
import com.avasafir.learning.serveice.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<StudentDto> saveStudent(@RequestBody Student student){
        Student savedStudent = studentService.saveStudent(student);
        StudentDto studentDto = StudentMapper.INSTANCE.entityToDto(savedStudent);
        return new ResponseEntity<>(studentDto, HttpStatus.OK);
    }
}
