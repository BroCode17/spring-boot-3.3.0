package com.efrimpon.lesson.database.student;

//Validations

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record StudentDTO(
        @NotEmpty(message = "First name should not be empty")
        String firstName,
        @NotEmpty(message = "Last name should not be empty")
        String lastName,

        String email,

        int schoolId
) {
}
