package com.efrimpon.lesson.database.school;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SchoolController {

    private SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping("/schools")
    public SchoolDTO creat(
            @RequestBody SchoolDTO dto
    ) {
        return this.schoolService.creat(dto);
    }


    @GetMapping("/schools")
    public List<SchoolDTO> getAllSchool(
    ) {
        return this.schoolService.getAllSchool();
    }

}