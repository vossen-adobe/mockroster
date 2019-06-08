package com.carag.mockroster.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class EntityBase<U> {

    @Id
    @GeneratedValue(generator = "sourced_id")
    @GenericGenerator(
            name = "sourced_id",
            strategy = "com.carag.mockroster.configuration.SourcedIdGenerator")

    @Column
    private String sourcedId;

//    @CreatedDate
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    @Column(name = "date_last_modified", updatable = false)
//    private LocalDateTime createdDate = LocalDateTime.now();

    @LastModifiedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column
    private LocalDateTime dateLastModified = LocalDateTime.now();

    @Column
    private String metadata;

    @Column
    private String status = "active";

}