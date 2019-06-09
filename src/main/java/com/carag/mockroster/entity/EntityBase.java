package com.carag.mockroster.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.apache.lucene.analysis.core.LowerCaseFilterFactory;
import org.apache.lucene.analysis.core.StopFilterFactory;
import org.apache.lucene.analysis.en.EnglishPossessiveFilterFactory;
import org.apache.lucene.analysis.standard.ClassicTokenizerFactory;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.search.annotations.*;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@AnalyzerDef(
        name = "customanalyzer",
        tokenizer = @TokenizerDef(factory = ClassicTokenizerFactory.class),
        filters = {
                @TokenFilterDef(factory = LowerCaseFilterFactory.class),
                @TokenFilterDef(factory = StopFilterFactory.class),
                @TokenFilterDef(factory = EnglishPossessiveFilterFactory.class)
        }
)

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Analyzer(definition = "customanalyzer")
public class EntityBase<U> {

    @Id
    @GeneratedValue(generator = "sourced_id")
    @GenericGenerator(
            name = "sourced_id",
            strategy = "com.carag.mockroster.configuration.SourcedIdGenerator")

    @Column
    @Field(name="id")
    private String sourcedId;

//    @CreatedDate
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    @Column(name = "date_last_modified", updatable = false)
//    private LocalDateTime createdDate = LocalDateTime.now();

    @LastModifiedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column
    @Field
    private LocalDateTime dateLastModified = LocalDateTime.now();

    @Field
    @Column
    private String metadata;

    @Field
    @Column
    private String status = "active";

}