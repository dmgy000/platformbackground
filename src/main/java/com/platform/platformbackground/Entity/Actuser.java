package com.platform.platformbackground.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "act_user")
public class Actuser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer actid;

    private Integer uid;
}
