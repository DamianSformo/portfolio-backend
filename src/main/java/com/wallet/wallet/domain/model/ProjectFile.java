package com.wallet.wallet.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wallet.wallet.domain.enums.ERecordStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "project_file")
@Data
public class ProjectFile {

    @Id
    @SequenceGenerator(name = "projectFileSequence", sequenceName = "projectFileSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "projectFileSequence")
    private Long id;

    @Column(name = "type", nullable = true)
    //@NotNull
    private String type;

    @Column(name = "url", nullable = true)
    //@NotNull
    private String url;

    @Column(name = "text_es", nullable = true)
    //@NotNull
    private String textEs;

    @Column(name = "text_en", nullable = true)
    //@NotNull
    private String textEn;

    @Column(nullable = true)
    //@NotNull
    private Boolean isCover;

    @Column(name = "order_index", nullable = true)
    private Integer orderIndex;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "record_update", nullable = true)
    //@NotNull
    private Date recordUpdate;

    @Column(name = "record_status", nullable = true, columnDefinition = "VARCHAR(2) DEFAULT 'A'")
    @Enumerated(EnumType.STRING)
    //@NotBlank
    private ERecordStatus recordStatus = ERecordStatus.A;

    @ManyToOne
    @JoinColumn(name = "project_id", referencedColumnName = "id", nullable = true)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    //@NotNull
    private Project project;

}