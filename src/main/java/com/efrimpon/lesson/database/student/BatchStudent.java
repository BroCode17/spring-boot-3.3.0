package com.efrimpon.lesson.database.student;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class BatchStudent{

    @Id
    @GeneratedValue
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
}
