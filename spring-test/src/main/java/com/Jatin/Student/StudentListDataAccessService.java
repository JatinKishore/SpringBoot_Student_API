package com.Jatin.Student;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository("list")

public class StudentListDataAccessService implements StudentDao {
    private static List<Student> students;

    static{
        students = new ArrayList<>();
        Student ayyas = new Student("Ayyas",1,"ayyas@gamil.com",11);
        Student aravind = new Student("Aravind",2,"arav@gila.com",12);
        students.add(ayyas);
        students.add(aravind);
    }
    @Override
    public List<Student> selectAllStudents() {
        return students;
    }

    @Override
    public Optional<Student> selectStudentById(Integer id) {
        return students.stream().filter(student -> student.getId().equals(id))
                .findFirst();
    }

    @Override
    public void insertStudent(Student student) {
        students.add(student);
    }

    @Override
    public boolean existsStudentWithMail(String email) {
        return students.stream().anyMatch(s -> s.getEmail().equals(email));
    }

    @Override
    public boolean existsStudentWithId(Integer id) {
        return students.stream().anyMatch(s -> s.getId().equals(id));
    }

    @Override
    public void deleteStudentbyId(Integer studentId) {
        students.stream().filter(s -> s.getId().equals(studentId)).findFirst().ifPresent(o-> students.remove(o));
    }

    @Override
    public void updateStudent(Student update) {
        students.add(update);
    }
}
