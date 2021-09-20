package com.dimevision.springboot.managementsystem.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Class representing database entity
 *
 * @author Dimevision
 * @version 0.1
 */

@Entity
@Table(name = "students")
@ToString
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "study_group")
    private String study_group;

    @Column(name = "course")
    private int course;
}
