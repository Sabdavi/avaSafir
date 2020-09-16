package com.avasafir.learning.repository;

import com.avasafir.learning.domain.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student,Long> {
}
