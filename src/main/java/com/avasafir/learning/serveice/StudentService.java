package com.avasafir.learning.serveice;

import com.avasafir.learning.domain.Student;
import com.avasafir.learning.mapper.StudentMapper;
import com.avasafir.learning.model.StudentDto;
import com.avasafir.learning.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }
    public Iterable<Student> students(){
        return studentRepository.findAll();
    }
    public Student updateStudent(StudentDto studentDto){
         return studentRepository.save(StudentMapper.INSTANCE.toEntity(studentDto));
    }
    public Optional<Long> deleteStudent(long id){
        return findStudent(id).map(student -> {studentRepository.delete(student);
        return student.getId();});
    }
    public Optional<Student> findStudent(long id){
        return studentRepository.findById(id);
    }
}
