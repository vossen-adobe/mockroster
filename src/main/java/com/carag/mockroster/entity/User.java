package com.carag.mockroster.entity;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;


@Data
@Entity
@Table(name = "challenge")

public class User extends EntityBase<String> {

    @Column(name = "question", columnDefinition = "TEXT")
    private String question;

    @Column(name = "answer", columnDefinition = "TEXT")
    private String answer;

    @Column(name = "author", updatable = false)
    private String author;

    @Column(name = "lastauthor")
    private String lastAuthor = "anonymous";


}
