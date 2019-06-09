package com.carag.mockroster.entity;


import lombok.Data;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Data
@Entity
@Table
@Indexed
public class Course extends EntityBase<String> {

    @Column
    @Field
    private String title;

    @Column
    @Field
    private String schoolYear;

    @Column
    @Field
    private String courseCode;

    @Column
    @Field
    private String grades;

    @Column
    @Field
    private String subjects;

    @Column
    @Field
    private String school;

    @Column
    @Field
    private String subjectCodes;

    @Column
    @Field
    private String resources;

}