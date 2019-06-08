package com.carag.mockroster.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Data
@Entity
@Table

public class School extends EntityBase<String> {

    @Column
    private String name;

    @Column
    private String type;

    @Column
    private String identifier;

    @Column
    private String parent;

    @Column
    private String children;
}
