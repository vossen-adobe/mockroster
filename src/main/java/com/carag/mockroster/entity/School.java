package com.carag.mockroster.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Getter @Setter
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

    @JsonIgnore
    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "schools"
    )
    private List<User> userList = new ArrayList<>();
}
