package com.carag.mockroster.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Data
@Entity
@Table

public class Course extends EntityBase<String> {

    @Column
    private String title;

    @Column
    private String schoolYear;

    @Column
    private String courseCode;

    @Column
    private String grades;

    @Column
    private String subjects;

    @Column
    private String school;

    @Column
    private String subjectCodes;

    @Column
    private String resources;

}