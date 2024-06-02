package com.efrimpon.lesson.database.school;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository  extends JpaRepository<School, Integer> {
}
