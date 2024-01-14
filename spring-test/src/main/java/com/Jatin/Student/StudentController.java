package com.Jatin.Student;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudent(){
        return studentService.getAllStudents();
    }

    @GetMapping("{studentId}")
    public Student getOneStudent(@PathVariable("studentId") Integer id){
        return studentService.getStudent(id);
    }

    @PostMapping
    public  void registerStudent(@RequestBody  StudentRegRequest studentRegRequest){
        studentService.addStudent(studentRegRequest);
    }

    @DeleteMapping("{studentId}")
    public void deleteStudent(@PathVariable("studentId") Integer studentId){
        studentService.deleteStudentById(studentId);
    }

    @PutMapping("{studentId}")
    public void putStudent(@PathVariable("studentId") Integer studentId, @RequestBody StudentUpdateRequest studentUpdateRequest){
        studentService.updateStudent(studentId, studentUpdateRequest);
    }


}
