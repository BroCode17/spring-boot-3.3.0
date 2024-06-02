package com.efrimpon.lesson.database.student;

import com.efrimpon.lesson.database.school.SchoolRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    //which service we want to test
    @InjectMocks
    private  StudentService studentService;


    //declare the dependencies
    @Mock
    private StudentRepository studentRepository;
    @Mock
    private SchoolRepository schoolRepository;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void should_successfully_save_a_student() {
       //Given
        StudentDTO dto = new StudentDTO("Bro", "Code", "me@you.com", 1);

        Student student = new Student(0,"Bro", "Code",1, "me@you.com");

       //mock the calls
        //Mockito.when(studentService.getStudents(dto)).thenReturn(student);

       //When
        StudentResponseDTO studentResponseDTO = studentService.saveStudent(dto);
       //Then
        assertEquals(dto.firstName(), studentResponseDTO.firstName());
        assertEquals(dto.lastName(), studentResponseDTO.lastName());
        assertEquals(dto.email(), studentResponseDTO.email());
    }
}