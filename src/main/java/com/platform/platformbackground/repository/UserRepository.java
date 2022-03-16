package com.platform.platformbackground.repository;

import com.platform.platformbackground.Entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {

    @Select("select id,userName,password,school,number from user where userName=#{name}")
    public User selectUser(@Param("name") String name);

    @Insert("insert into user(userName,password,school,number) values(#{name},#{password},#{school},#{number})")
    public int insertUser(@Param("name")String name,@Param("password")String password,@Param("school")String school,@Param("number")Integer number);
}
