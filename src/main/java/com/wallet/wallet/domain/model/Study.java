package com.wallet.wallet.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wallet.wallet.domain.enums.ERecordStatus;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "study")
@Data
public class Study {

    @Id
    @SequenceGenerator(name = "studySequence", sequenceName = "studySequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "studySequence")
    private Long id;

    @Column(name = "start_year")
    //@NotNull
    private Integer startYear;

    @Column(name = "end_year")
    //@NotNull
    private Integer endYear;

    @Column(name = "description_es")
    //@NotNull
    private String descriptionEs;

    @Column(name = "description_en")
    //@NotNull
    private String descriptionEn;

    //@NotNull
    private String site;

    @Column(name = "order_index", nullable = true)
    private Integer orderIndex;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "record_update")
    //@NotNull
    private Date recordUpdate;

    @Column(name = "record_status", nullable = false, columnDefinition = "VARCHAR(2) DEFAULT 'A'")
    @Enumerated(EnumType.STRING)
    @NotNull
    private ERecordStatus recordStatus = ERecordStatus.A;

    @PrePersist
    @PreUpdate
    protected void onUpdate() {
        recordUpdate = new Date();
    }

}