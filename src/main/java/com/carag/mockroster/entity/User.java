package com.carag.mockroster.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;

import javax.persistence.*;
import java.util.Set;


@Getter @Setter

@Entity
@Table
@ToString
@Indexed
public class User extends EntityBase<String> {

    @Field
    @Column
    private String username;

    @Field
    @Column
    private String userIds;

    @Field
    @Column
    private boolean enabledUser;

    @Field
    @Column
    private String givenName;

    @Field
    @Column
    private String familyName;

    @Field
    @Column
    private String middleName;

    @Field
    @Column
    private String role;

    @Field
    @Column
    private String identifier;

    @Field
    @Column
    private String email;

    @Field
    @Column
    private String sms;

    @Field
    @Column
    private String phone;

    @Field
    @Column
    private String agents;

    @Field
    @Column
    private String schools;

    @Field
    @Column
    private String grades;

    @Field
    @Column
    private String password;

    //@JsonIgnore

    @IndexedEmbedded//(depth = 1)
    @JsonIgnoreProperties("userSet")
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "enrollment",
            joinColumns = @JoinColumn(name = "user", referencedColumnName = "sourcedId"),
            inverseJoinColumns = @JoinColumn(name = "section", referencedColumnName = "sourcedId"))
    private Set<Section> sectionSet;
//
//   // @JsonIgnore
//    @ManyToOne
//    @JoinColumn(name = "schools", insertable = false, updatable = false)
//    private School schoolObj;
}

