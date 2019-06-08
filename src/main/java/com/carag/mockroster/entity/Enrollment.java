package com.carag.mockroster.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data
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
