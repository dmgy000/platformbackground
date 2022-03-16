package com.platform.platformbackground.Controller;

import com.platform.platformbackground.Entity.School;
import com.platform.platformbackground.repository.SchoolRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/school")
public class SchoolController {
    @Autowired
    private SchoolRepository schoolRepository;

    @GetMapping("/findAll")
    public List<School> findAll(){
        return schoolRepository.findAll();
    }

}
