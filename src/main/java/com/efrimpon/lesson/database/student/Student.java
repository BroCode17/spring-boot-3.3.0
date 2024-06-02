package com.efrimpon.lesson.database.student;

import com.efrimpon.lesson.database.school.School;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "T_STUDENT") // Change table name
public class Student {


    @Id // Primary id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
     // change column name
    private String firstName;
    private String lastName;
    private int age;
    @Column(unique = true)
    private String email;

    public StudentProfile getStudentProfile() {
        return studentProfile;
    }

    public void setStudentProfile(StudentProfile studentProfile) {
        this.studentProfile = studentProfile;
    }
    //One student can have one Student Profile
    @OneToOne( mappedBy = "student", cascade = CascadeType.ALL)
    private StudentProfile studentProfile;

    //A student can have one school
    @ManyToOne()
    @JoinColumn(
            name= "school_id"
    )
    @JsonBackReference // Prevent recursion
    private School school;





    //This is necessary
    public Student() {}

    public Student(int id, String firstName, String lastName, int age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
    }

    //Batch Student
    public Student(int id, String firstName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
