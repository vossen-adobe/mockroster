package com.carag.mockroster.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;


@Data
@Entity
@Table

public class AcademicSession extends EntityBase<String> {

    @Column
    private String title;

    @Column
    private String type;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column
    private LocalDateTime startDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column
    private LocalDateTime endDate;

    @Column
    private String parent;

    @Column
    private String children;

    @Column
    private String schoolYear;

}