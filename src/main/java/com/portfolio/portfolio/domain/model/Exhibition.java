package com.portfolio.portfolio.domain.model;

import com.portfolio.portfolio.domain.enums.EExhibitionType;
import com.portfolio.portfolio.domain.enums.ERecordStatus;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "exhibition", indexes = {
        @Index(name = "idx_record_status", columnList = "record_status"),
        @Index(name = "idx_type", columnList = "type"),
        @Index(name = "idx_record_status_type", columnList = "record_status, type")
})
@Data
public class Exhibition {

    @Id
    @SequenceGenerator(name = "exhibitionSequence", sequenceName = "exhibitionSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "exhibitionSequence")
    private Long id;

    @Enumerated(EnumType.STRING)
    private EExhibitionType type;

    @Column(nullable = false)
    private Integer year;

    @Column(name = "title_es", nullable = false, length = 255)
    private String titleEs;

    @Column(name = "title_en", nullable = false, length = 255)
    private String titleEn;

    @Column(name = "text_es", nullable = false, length = 255)
    private String textEs;

    @Column(name = "text_en", nullable = false, length = 255)
    private String textEn;

    @Column(name = "record_creation", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date recordCreation;

    @Column(name = "record_update", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date recordUpdate;

    @Column(name = "record_status", nullable = false, columnDefinition = "VARCHAR(1) DEFAULT 'A'")
    @Enumerated(EnumType.STRING)
    private ERecordStatus recordStatus = ERecordStatus.A;

}