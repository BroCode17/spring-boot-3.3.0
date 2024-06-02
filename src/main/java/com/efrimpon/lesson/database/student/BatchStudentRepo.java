package com.efrimpon.lesson.database.student;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BatchStudentRepo extends JpaRepository<BatchStudent, Integer> {
}

