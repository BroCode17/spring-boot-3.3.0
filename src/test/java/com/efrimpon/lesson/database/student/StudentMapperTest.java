package com.efrimpon.lesson.database.student;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {

//    @BeforeAll
//    static void beforeAll() {
//        System.out.println("Before All");
//    }
//
//    @AfterAll
//    static void afterAll() {
//        System.out.println("Inside after all");
//    }
//
//    @BeforeEach
//    void setUp1() {
//        System.out.println("Before each test");
//    }
//
//    @Test
//    void getStudent() {
//        System.out.println("My first text method");
//    }
//
//    @AfterEach
//    void tearDown() {
//        System.out.println("After each test");
//    }
//
//    @BeforeEach
//    void setUp2() {
//        System.out.println("Before each test");
//    }
//
//    @Test
//    void getStudent2() {
//        System.out.println("My first text method");
//    }


    private StudentMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new StudentMapper();
    }
    @Test
    void shouldMapStudentDtoStudent() {
        StudentDTO dto = new StudentDTO("Bro", "Code", "me@you.com", 1);

        Student student = mapper.toStudent(dto);

        assertEquals(dto.firstName(), student.getFirstName());
        assertEquals(dto.lastName(), student.getLastName());
        assertEquals(dto.email(), student.getEmail());
        assertNotNull(student.getSchool());
        assertEquals(dto.schoolId(), student.getSchool().getId());
    }

    @BeforeEach
    void setUp1() {
        mapper = new StudentMapper();
    }

    @Test
    void should_throw_null_pointer_exception_when_studentDto__is_null(){
        var msg = assertThrows(NullPointerException.class, () -> mapper.toStudent(null));
        assertEquals("The student cannot be null", msg.getMessage());
    }

    @Test
    void shouldMapStudentDtoStudent2() {
        // Given
        Student student = new Student(1, "Bro", "Code",  20, "you@me.com");

        //when
        StudentResponseDTO res = mapper.toStudentResponseDTO(student);

        // then
        assertEquals(res.firstName(), student.getFirstName());
        assertEquals(res.lastName(), student.getLastName());
        assertEquals(res.email(), student.getEmail());
    }
}
