package com.avasafir.learning.mapper;

import com.avasafir.learning.domain.Student;
import com.avasafir.learning.model.StudentDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);
    StudentDto entityToDto(Student student);
}
