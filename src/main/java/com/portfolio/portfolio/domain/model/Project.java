package com.portfolio.portfolio.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.portfolio.portfolio.domain.enums.ERecordStatus;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "project", indexes = {
        @Index(name = "idx_record_status", columnList = "record_status")
})
@Data
public class Project {

    @Id
    @SequenceGenerator(name = "projectSequence", sequenceName = "projectSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "projectSequence")
    private Long id;

    @Column(name = "title_es", nullable = false)
    @NotNull
    private String titleEs;

    @Column(name = "title_en", nullable = false)
    @NotNull
    private String titleEn;

    @Lob
    @Column(name = "description_es", nullable = false)
    @NotNull
    private String descriptionEs;

    @Lob
    @Column(name = "description_en", nullable = false)
    @NotNull
    private String descriptionEn;

    @Column(name = "text_es", nullable = false)
    @NotNull
    private String textEs;

    @Column(name = "text_en", nullable = false)
    @NotNull
    private String textEn;

    @Column(nullable = false)
    @NotNull
    private Integer year;

    @Column(nullable = false)
    @NotNull
    private String site;

    @Column(name = "technique_es", nullable = false)
    @NotNull
    private String techniqueEs;

    @Column(name = "technique_en", nullable = false)
    @NotNull
    private String techniqueEn;

    @Column(name = "order_index", nullable = false)
    @NotNull
    private Integer orderIndex;

    @Column(name = "record_update")
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date recordUpdate;

    @Column(name = "record_status", nullable = false, columnDefinition = "VARCHAR(2) DEFAULT 'A'")
    @Enumerated(EnumType.STRING)
    @NotNull
    private ERecordStatus recordStatus = ERecordStatus.A;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<ProjectFile> projectFiles;

}