package com.carag.mockroster.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
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

    @JsonIgnore
    @ManyToMany(mappedBy = "sectionSet", fetch = FetchType.LAZY)
    private Set<User> userSet = new HashSet<>();

}
