package com.ajay.app.repository;

import com.ajay.app.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepositiory extends JpaRepository<Student, Integer> {
    Student getByName(String name);

    Student findByName(String name);
}
