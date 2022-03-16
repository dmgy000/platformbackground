package com.platform.platformbackground.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "school")
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
}
