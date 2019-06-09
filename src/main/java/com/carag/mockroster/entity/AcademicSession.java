package com.carag.mockroster.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import java.time.LocalDateTime;


@Data
@Entity
@Table
@Indexed
public class AcademicSession extends EntityBase<String> {

    @Column
    @Field
    private String title;

    @Column
    @Field
    private String type;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column
    @Field
    private LocalDateTime startDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column
    @Field
    private LocalDateTime endDate;

    @Column
    @Field
    private String parent;

    @Column
    @Field
    private String children;

    @Column
    @Field
    private String schoolYear;

}