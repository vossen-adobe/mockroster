package com.carag.mockroster.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Data
@Entity
@Table

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
    private String orgs;

    @Column
    private String grades;

    @Column
    private String password;

}

