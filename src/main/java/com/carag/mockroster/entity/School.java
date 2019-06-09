package com.carag.mockroster.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter @Setter
@Entity
@Table
@Indexed
public class School extends EntityBase<String> {

    @Column
    @Field
    private String name;

    @Column
    @Field
    private String type;

    @Column
    @Field
    private String identifier;

    @Column
    @Field
    private String parent;

    @Column
    @Field
    private String children;

//    @JsonIgnore
//    @OneToMany(
//            fetch = FetchType.LAZY,
//            mappedBy = "schools"
//    )
//    private List<User> userList = new ArrayList<>();
}
