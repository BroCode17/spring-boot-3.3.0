//package com.efrimpon.lesson.rest;
//
//import com.efrimpon.lesson.database.Student;
//import com.efrimpon.lesson.database.student.StudentRepository;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//public class FirstController {
//
//    private final StudentRepository studentRepository;
//
//    public FirstController(StudentRepository studentRepository) {
//        this.studentRepository = studentRepository;
//    }
//
//    //    @GetMapping("/hello")
////    @ResponseStatus(HttpStatus.ACCEPTED)
////    public String hello() {
////        return "Hello World from my first controller";
////    }
////
////    @PostMapping("/hello1")
////    public String postHello(
////           @RequestBody String mess
////    ) {
////        return "Request Accepted" + mess;
////    }
////
////    @PostMapping("/post-order")
////    public String postOrder(
////            @RequestBody Order order
////    ){
////        return "Order Accepted: " + order.toString();
////    }
//
//    // http://localhost:8080/hello/brocode
////    @GetMapping("/hell/{id}")
////    public String pathVariable(
////            @PathVariable("id") String userName
////    ) {
////        return "ParamValue = "+ userName;
////    }
////
////    @GetMapping("/hell")
////    public String paramVar(
////            @RequestParam("id") String userName
////    ) {
////        return "ParamValue = "+ userName;
////    }
//
//      @PostMapping("/student")
//    public Student saveStudent(@RequestBody Student student) {
//        return studentRepository.save(student);
//      }
//
//      @GetMapping("/students/{student-id}")
//    public Student getById(@PathVariable("student-id") int studentId) {
//        return studentRepository.findById(studentId).orElse(null);
//      }
//      @GetMapping("/students")
//    public List<Student> getById() {
//        return studentRepository.findAll();
//      }
//      @GetMapping("/students/search/{student-name}")
//    public List<Student> getStudentByName(@PathVariable("student-name") String studentName) {
//        return studentRepository.findAllByFirstName(studentName);
//      }
//
//       @DeleteMapping("/students/{id}")
//
//    public HttpStatus deleteById(@PathVariable("id") Integer id) {
//         studentRepository.deleteById(id);
//         return HttpStatus.ACCEPTED;
//      }
//
//
//}
