package com.Jatin.Student;

import java.util.List;
import java.util.Optional;

public interface StudentDao {
    List<Student> selectAllStudents();

    Optional<Student> selectStudentById(Integer id);

    void insertStudent(Student student);
    boolean existsStudentWithMail(String email);

    boolean existsStudentWithId(Integer id);

    void deleteStudentbyId(Integer studentId);

    void updateStudent(Student update);
}
