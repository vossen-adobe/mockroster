package com.carag.mockroster.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Getter @Setter

@Entity
@Table
@ToString
public class User extends EntityBase<String> {

    @Column
    private String username;

    @Column
    private String userIds;

    @Column
    private boolean enabledUser;

    @Column
    private String givenName;

    @Column
    private String familyName;

    @Column
    private String middleName;

    @Column
    private String role;

    @Column
    private String identifier;

    @Column
    private String email;

    @Column
    private String sms;

    @Column
    private String phone;

    @Column
    private String agents;

    @Column
    private String schools;

    @Column
    private String grades;

    @Column
    private String password;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "enrollment",
            joinColumns = @JoinColumn(name = "user", referencedColumnName = "sourcedId"),
            inverseJoinColumns = @JoinColumn(name = "section", referencedColumnName = "sourcedId"))
    private Set<Section> sectionSet;
}

