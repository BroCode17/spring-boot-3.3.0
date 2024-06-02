package com.efrimpon.lesson.database.student;

import com.efrimpon.lesson.database.school.School;

public class StudentMapper {

    public Student toStudent(StudentDTO dto) {
        if (dto == null){
            throw new NullPointerException("The student cannot be null");
        }
        var student = new Student();
        student.setFirstName(dto.firstName());
        student.setLastName(dto.lastName());
        student.setEmail(dto.email());


        School school = new School();
        school.setId(dto.schoolId());
        student.setSchool(school);
        return student;
    }


    public StudentResponseDTO toStudentResponseDTO(Student student){
        return new StudentResponseDTO(student.getFirstName(), student.getLastName(), student.getEmail());
    }
}
