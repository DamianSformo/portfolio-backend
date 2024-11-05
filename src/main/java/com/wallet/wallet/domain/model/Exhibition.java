package com.wallet.wallet.domain.model;

import com.wallet.wallet.domain.enums.EExhibitionType;
import com.wallet.wallet.domain.enums.ERecordStatus;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "exhibition", indexes = {
        @Index(name = "idx_record_status", columnList = "record_status"),
        @Index(name = "idx_type", columnList = "type")
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
    @NotNull
    private Integer year;

    @Column(name = "title_es", nullable = false)
    @NotNull
    private String titleEs;

    @Column(name = "title_en", nullable = false)
    @NotNull
    private String titleEn;

    @Column(name = "text_es", nullable = false)
    @NotNull
    private String textEs;

    @Column(name = "text_en", nullable = false)
    @NotNull
    private String textEn;

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

}