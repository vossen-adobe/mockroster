package com.carag.mockroster.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter @Setter
@Entity
@Table
@Indexed
public class Enrollment extends EntityBase<String> {

    @Column
    @Field
    private String user;

    @Column
    @Field
    private String section;

    @Column
    @Field
    private String school;

    @Column
    @Field
    private String role;

    @Column
    @Field
    private String primaryUser;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column
    @Field
    private LocalDateTime beginDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column
    @Field
    private LocalDateTime endDate;

}
