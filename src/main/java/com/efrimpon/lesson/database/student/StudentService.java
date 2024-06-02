package com.efrimpon.lesson.database.student;

import com.efrimpon.lesson.database.school.SchoolRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final SchoolRepository schoolRepository;

    public StudentService(StudentRepository studentRepository, SchoolRepository schoolRepository) {
        this.studentRepository = studentRepository;
        this.schoolRepository = schoolRepository;
    }

    public StudentResponseDTO saveStudent(StudentDTO studentDTO) {
        var modifiedStudent = toStudent(studentDTO);
        var savedStudent  = studentRepository.save(modifiedStudent);
        return getStudentResponseDTO(savedStudent);
    }

    private Student toStudent(StudentDTO dto) {
        var student = new Student();
        student.setFirstName(dto.firstName());
        student.setLastName(dto.lastName());
        student.setEmail(dto.email());
        //get school from db based on the id

        var school = schoolRepository.findById(dto.schoolId()).orElse(null);
        if(school != null) {
            System.out.println(school.getId());
        }
        student.setSchool(school);
        return student;
    }


    private StudentResponseDTO getStudentResponseDTO(Student student) {
        return new StudentResponseDTO(student.getFirstName(), student.getLastName(), student.getEmail());
    }

    //get all student
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    //get student by id
    public Student getStudent(@PathVariable int id) {
        return studentRepository.findById(id).orElse(null);
    }

    //get student by name
    public List<Student> getStudentByStudentName(String studentName) {
        return studentRepository.findAllByFirstName(studentName);
    }

    //delete student
    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }

}
