package com.efrimpon.lesson.database.student;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class StudentController {


    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //get all student
    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    //get student by id
    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable int id) {
        return studentService.getStudent(id);
    }


    //get student by name
    @GetMapping("/students/{student-name}")
    public List<Student> getStudentByStudentName(
            @PathVariable("student-name") String studentName
    ) {
        return studentService.getStudentByStudentName(studentName);
    }

    //post student
//    @PostMapping("/students")
//    public StudentResponseDTO saveStudent(@Valid @RequestBody StudentDTO studentDTO) {
//            return this.studentService.saveStudent(studentDTO);
//    }


    //delete student by id
    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable int id) {
       studentService.deleteStudent(id);
    }


    //Error handling -> Overriding the default error
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException ex
    ){
        var error = new HashMap<String, String>();
        //return a list of error
        ex.getBindingResult().getAllErrors().forEach(err -> {
            //extract field name an
            var fieldName = ((FieldError) err).getField();
            var errorMessage = err.getDefaultMessage();
            error.put(fieldName, errorMessage);
        });

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
