package com.carag.mockroster.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter @Setter
@Entity
@Table

public class Enrollment extends EntityBase<String> {

    @Column
    private String user;

    @Column
    private String section;

    @Column
    private String school;

    @Column
    private String role;

    @Column
    private String primaryUser;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column
    private LocalDateTime beginDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column
    private LocalDateTime endDate;

}
