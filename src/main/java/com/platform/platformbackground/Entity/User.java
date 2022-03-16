package com.platform.platformbackground.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue
    private Integer id;

    private String userName;

    private String password;

    private String school;

    private Integer number;

    private String token;
}
