package com.efrimpon.lesson.database.school;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService {

    private final SchoolRepository schoolRepository;

    public SchoolService(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    public SchoolDTO creat(SchoolDTO dto ) {
        var school  = toSchool(dto);
        schoolRepository.save(school);
        return dto;
    }

    private School toSchool(SchoolDTO school) {
        return new School(school.name());
    }

    public List<SchoolDTO> getAllSchool(
    ) {
        return schoolRepository.findAll()
                .stream()
                .map(this::toSchoolDTO)
                .collect(Collectors.toList());
    }

    private SchoolDTO toSchoolDTO(School school) {
        return new SchoolDTO(school.getName());
    }
}
