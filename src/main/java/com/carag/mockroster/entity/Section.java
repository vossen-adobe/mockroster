package com.carag.mockroster.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@Entity
@Table
@Indexed
public class Section extends EntityBase<String> {

    @Column
    @Field
    private String title;

    @Column
    @Field
    private String classCode;

    @Column
    @Field
    private String classType;

    @Column
    @Field
    private String location;

    @Column
    @Field
    private String grades;

    @Column
    @Field
    private String subjects;

    @Column
    @Field
    private String course;

    @Column
    @Field
    private String school;

    @Column
    @Field
    private String terms;

    @Column
    @Field
    private String subjectCodes;

    @Column
    @Field
    private String periods;

    @Column
    @Field
    private String resources;

    @IndexedEmbedded(depth = 1)
    @JsonIgnoreProperties("sectionSet")
    @ManyToMany(mappedBy = "sectionSet", fetch = FetchType.LAZY)
    private Set<User> userSet = new HashSet<>();

}
