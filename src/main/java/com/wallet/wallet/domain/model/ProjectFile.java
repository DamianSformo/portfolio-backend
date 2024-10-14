package com.wallet.wallet.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wallet.wallet.domain.enums.ERecordStatus;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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

    @Column(nullable = false)
    @NotNull
    private String url;

    @Column(name = "text_es", nullable = false)
    @NotNull
    private String textEs;

    @Column(name = "text_en", nullable = false)
    @NotNull
    private String textEn;

    @Column(name = "is_cover", nullable = true)
    //@NotNull
    private Boolean isCover;

    @Column(name = "order_index", nullable = true)
    private Integer orderIndex;

    @Column(name = "record_update")
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date recordUpdate;

    @Column(name = "record_status", nullable = false, columnDefinition = "VARCHAR(2) DEFAULT 'A'")
    @Enumerated(EnumType.STRING)
    @NotNull
    private ERecordStatus recordStatus = ERecordStatus.A;

    @ManyToOne
    @JoinColumn(name = "project_id", referencedColumnName = "id", nullable = true)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    //@NotNull
    private Project project;

}