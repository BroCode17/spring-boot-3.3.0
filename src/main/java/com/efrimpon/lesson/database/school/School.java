package com.efrimpon.lesson.database.school;

import com.efrimpon.lesson.database.student.Student;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class School {

    @Id
    @GeneratedValue
    private int id;
    private String name;

    //One school can have many student
    @OneToMany(
            mappedBy = "school"
//            cascade = CascadeType.ALL
    )
    @JsonManagedReference // To recursion error
    private List<Student> student;


    public School() {
    }


    public School(String name) {
        this.name = name;
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
