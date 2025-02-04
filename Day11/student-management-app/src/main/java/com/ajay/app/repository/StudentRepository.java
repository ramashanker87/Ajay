package com.ajay.app.repository;
import com.ajay.app.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface StudentRepository extends CrudRepository<Student, Integer>{
}

