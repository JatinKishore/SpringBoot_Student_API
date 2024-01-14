package com.Jatin.Student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository  extends JpaRepository<Student,Integer> {
    boolean existsStudentByEmail(String email);
    boolean existsStudentById(Integer id);
}
