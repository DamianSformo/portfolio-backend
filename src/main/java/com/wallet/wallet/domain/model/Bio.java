package com.wallet.wallet.domain.model;

import com.wallet.wallet.domain.enums.ERecordStatus;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "bio")
@Data
public class Bio {

    @Id
    @SequenceGenerator(name = "bioSequence", sequenceName = "bioSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bioSequence")
    private Long id;

    @Column(nullable = false)
    @NotNull
    private String name;

    @Column(name = "url_photo", nullable = false)
    @NotNull
    private String urlPhoto;

    @Column(name = "text_photo_es", nullable = false)
    @NotNull
    private String textPhotoEs;

    @Column(name = "text_photo_en", nullable = false)
    @NotNull
    private String textPhotoEn;

    @Lob
    @Column(name = "bio_es", nullable = false)
    @NotNull
    private String bioEs;

    @Lob
    @Column(name = "bio_en", nullable = false)
    @NotNull
    private String bioEn;

    @Lob
    @Column(name = "bio_short_es", nullable = false)
    @NotNull
    private String bioShortEs;

    @Lob
    @Column(name = "bio_short_en", nullable = false)
    @NotNull
    private String bioShortEn;

    @Lob
    @Column(name = "statement_es", nullable = false)
    @NotNull
    private String statementEs;

    @Lob
    @Column(name = "statement_en", nullable = false)
    @NotNull
    private String statementEn;

    @Column(name = "record_update")
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date recordUpdate;

    @Column(name = "record_status", nullable = false, columnDefinition = "VARCHAR(2) DEFAULT 'A'")
    @Enumerated(EnumType.STRING)
    @NotNull
    private ERecordStatus recordStatus = ERecordStatus.A;

}