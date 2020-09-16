package com.avasafir.learning.controller;

import com.avasafir.learning.domain.Student;
import com.avasafir.learning.mapper.StudentMapper;
import com.avasafir.learning.model.StudentDto;
import com.avasafir.learning.serveice.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        StudentDto studentDto = StudentMapper.INSTANCE.toDto(savedStudent);
        return new ResponseEntity<>(studentDto, HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<StudentDto>> students(){
        List<StudentDto> studentDtos = new ArrayList<>();
        studentService.students().forEach(student -> studentDtos.add(StudentMapper.INSTANCE.toDto(student)));
        return new ResponseEntity<>(studentDtos,HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.GET,path = "/{id}")
    public Optional<StudentDto> findStudent(@PathVariable long id){
        return studentService.findStudent(id).map(student -> StudentMapper.INSTANCE.toDto(student));
    }
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<StudentDto> updateStudent(@RequestBody StudentDto studentDto){
        StudentDto dto = StudentMapper.INSTANCE.toDto(studentService.updateStudent(studentDto));
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.DELETE,path = "/{id}")
    public Optional<Long> deleteStudent(@PathVariable long id){
        return studentService.deleteStudent(id);
    }
}
