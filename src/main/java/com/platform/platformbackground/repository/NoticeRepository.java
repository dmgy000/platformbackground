package com.platform.platformbackground.repository;

import com.platform.platformbackground.Entity.Notice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeRepository extends JpaRepository<Notice,Integer> {
    public Page findBySchool(String name, Pageable pageable);
}
