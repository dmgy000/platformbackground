package com.platform.platformbackground.Controller;

import com.platform.platformbackground.Entity.Notice;
import com.platform.platformbackground.Entity.School;
import com.platform.platformbackground.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/notice")
public class NoticeController {
    @Autowired
    private NoticeRepository noticeRepository;

    @GetMapping("/findAll/{page}/{size}")
    public Page<Notice> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        Pageable pageable = PageRequest.of(page-1,size);
        return noticeRepository.findAll(pageable);
    }

    @GetMapping("/findById/{page}/{size}")
    public Page<Notice> findById(@PathVariable("page") Integer page, @PathVariable("size") Integer size, School school){
        String name=school.getName();
        System.out.println(name);
        if(name==null||name.equals("")){
            Pageable pageable = PageRequest.of(page-1,size);
            return noticeRepository.findAll(pageable);
        }
        else{
            Pageable pageable = PageRequest.of(page-1,size);
            return noticeRepository.findBySchool(name,pageable);
        }
    }
}
