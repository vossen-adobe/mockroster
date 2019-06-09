package com.carag.mockroster.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.search.annotations.Analyzer;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@Entity
@Table
@Indexed
@Analyzer(definition = "customanalyzer")
public class Section{ //} extends EntityBase<String> {

    @Id
    @GeneratedValue(generator = "sourced_id")
    @GenericGenerator(
            name = "sourced_id",
            strategy = "com.carag.mockroster.configuration.SourcedIdGenerator")

    @Column
    @Field (name="s1")
    private String sourcedId;

//    @CreatedDate
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    @Column(name = "date_last_modified", updatable = false)
//    private LocalDateTime createdDate = LocalDateTime.now();

    @LastModifiedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column
    @Field
    private LocalDateTime dateLastModified = LocalDateTime.now();

    @Field
    @Column
    private String metadata;

    @Field
    @Column
    private String status = "active";
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
