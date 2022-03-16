package com.platform.platformbackground.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "act_type")
public class Act_type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String type;
}
