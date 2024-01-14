package com.Jatin.Student;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public  class Student{
    @Id
    @SequenceGenerator(
            name = "student_id_sequence",
            sequenceName = "student_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_id_sequence"
    )
    private  Integer id;
    @Column(nullable = false)
    private String name;
    private String email;
    private Integer standard;


    public Student() {

    };

    public Student(String name, Integer id, String email, Integer standard) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.standard = standard;
    }
    public Student(String name, String email, Integer standard) {
        this.name = name;
        this.email = email;
        this.standard = standard;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + id +
                ", address='" + email + '\'' +
                ", standard=" + standard +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(id, student.id) && Objects.equals(email, student.email) && Objects.equals(standard, student.standard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, email, standard);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setStandard(Integer standard) {
        this.standard = standard;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public Integer getStandard() {
        return standard;
    }


}
