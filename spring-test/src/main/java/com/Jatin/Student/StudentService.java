package com.Jatin.Student;

import com.Jatin.exception.DuplicateResourceException;
import com.Jatin.exception.RequestValidationException;
import com.Jatin.exception.ResourceNotFound;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

//Business layer
@Service
public class StudentService {
    private final StudentDao studentDao;

    public StudentService(@Qualifier("jpa") StudentDao studentDao){
        this.studentDao = studentDao;
    }

    public List<Student> getAllStudents()
    {
        return studentDao.selectAllStudents();
    }
    public Student getStudent(Integer id){
        return studentDao.selectStudentById(id).orElseThrow(()-> new ResourceNotFound("Id not Found"));
    }
    public void addStudent(StudentRegRequest studentRegRequest){
        if(studentDao.existsStudentWithMail(studentRegRequest.email()))
        {
            throw new DuplicateResourceException("email already exist");
        }

        Student student = new Student(
                    studentRegRequest.name(),
                    studentRegRequest.email(),
                    studentRegRequest.standard()
            );
        studentDao.insertStudent(student);
    }
    public void deleteStudentById(Integer studentId){
        if(!studentDao.existsStudentWithId(studentId))
        {
            throw new ResourceNotFound("There is no student on this id");
        }
        studentDao.deleteStudentbyId(studentId);
    }
    public void updateStudent(Integer studentId, StudentUpdateRequest updateRequest){
        Student student = getStudent(studentId);
        boolean changes = false;

        if(updateRequest.name() != null && !updateRequest.name().equals(student.getName())){
            student.setName(updateRequest.name());
            changes = true;
        }
        if(updateRequest.email() != null && !updateRequest.email().equals(student.getEmail())){
            if(studentDao.existsStudentWithMail(updateRequest.email()))
            {
                throw new DuplicateResourceException("email already exist");
            }

            student.setEmail(updateRequest.email());
            changes = true;
        }
        if(updateRequest.standard() != null && !updateRequest.standard().equals(student.getStandard())){
            student.setStandard(updateRequest.standard());
            changes = true;
        }
        if(!changes)
        {
            throw new RequestValidationException("no data changes found");
        }
        studentDao.updateStudent(student);
    }




}

