package com.wallet.wallet.domain.model;

import com.wallet.wallet.domain.enums.ERecordStatus;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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

    @NotBlank
    private String name;

    @Column(name = "url_photo")
    @NotBlank
    private String urlPhoto;

    @Column(name = "text_photo_es")
    @NotBlank
    private String textPhotoEs;

    @Column(name = "text_photo_en")
    @NotNull
    private String textPhotoEn;

    @Column(name = "bio_es", columnDefinition = "TEXT")
    @NotBlank
    private String bioEs;

    @Column(name = "bio_en", columnDefinition = "TEXT")
    @NotNull
    private String bioEn;

    @Column(name = "bio_short_es", columnDefinition = "TEXT")
    @NotBlank
    private String bioShortEs;

    @Column(name = "bio_short_en", columnDefinition = "TEXT")
    @NotNull
    private String bioShortEn;

    @Column(name = "statement_es", columnDefinition = "TEXT")
    @NotBlank
    private String statementEs;

    @Column(name = "statement_en", columnDefinition = "TEXT")
    @NotNull
    private String statementEn;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "record_update")
    @NotNull
    private Date recordUpdate;

    @Column(name = "record_status", columnDefinition = "VARCHAR(2) DEFAULT 'A'")
    @Enumerated(EnumType.STRING)
    @NotNull
    private ERecordStatus recordStatus = ERecordStatus.A;

    @PrePersist
    @PreUpdate
    protected void onUpdate() {
        recordUpdate = new Date();
    }
}