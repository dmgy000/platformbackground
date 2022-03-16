package com.platform.platformbackground.Controller;

import com.platform.platformbackground.Entity.Act_type;
import com.platform.platformbackground.repository.Act_typeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/acttype")
public class Act_typeController {
    @Autowired
    private Act_typeRepository act_typeRepository;

    @GetMapping("/findAll")
    public List<Act_type> findAll(){
        return act_typeRepository.findAll();
    }
}
