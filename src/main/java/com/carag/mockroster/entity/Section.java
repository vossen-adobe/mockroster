package com.carag.mockroster.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Data
@Entity
@Table

public class Section extends EntityBase<String> {

    @Column
    private String title;

    @Column
    private String classCode;

    @Column
    private String classType;

    @Column
    private String location;

    @Column
    private String grades;

    @Column
    private String subjects;

    @Column
    private String course;

    @Column
    private String school;

    @Column
    private String terms;

    @Column
    private String subjectCodes;

    @Column
    private String periods;

    @Column
    private String resources;

}
