package com.wallet.wallet.domain.model;

import com.wallet.wallet.domain.enums.EExhibitionType;
import com.wallet.wallet.domain.enums.ERecordStatus;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "exhibition")
@Data
public class Exhibition {

    @Id
    @SequenceGenerator(name = "exhibitionSequence", sequenceName = "exhibitionSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "exhibitionSequence")
    private Long id;

    @Enumerated(EnumType.STRING)
    private EExhibitionType type;

    //@NotNull
    private Integer year;

    @Column(name = "text_es", nullable = false)
    @NotNull
    private String titleEs;

    @Column(name = "text_en")
    //@NotNull
    private String titleEn;

    @Column(name = "description_es")
    //@NotNull
    private String textEs;

    @Column(name = "description_en")
    //@NotNull
    private String textEn;

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