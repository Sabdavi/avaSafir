package com.avasafir.learning.repository;

import com.avasafir.learning.domain.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student,Long> {
}
