package com.portfolio.portfolio.domain.model;

import com.portfolio.portfolio.domain.enums.ERecordStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Entity
@Table(name = "study", indexes = {
        @Index(name = "idx_record_status", columnList = "record_status"),
})
public class Study {

    @Id
    @SequenceGenerator(name = "studySequence", sequenceName = "studySequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "studySequence")
    private Long id;

    @Column(name = "start_year")
    @NotNull
    private Integer startYear;

    @Column(name = "end_year")
    @NotNull
    private Integer endYear;

    @Column(name = "description_es")
    @NotNull
    private String descriptionEs;

    @Column(name = "description_en")
    @NotNull
    private String descriptionEn;

    @NotNull
    private String site;

    @Column(name = "record_update")
    @NotNull
    @UpdateTimestamp
    private LocalDateTime recordUpdate;

    @PrePersist
    @PreUpdate
    protected void onUpdate() {
        recordUpdate = LocalDateTime.now();
    }

    @Column(name = "record_status", columnDefinition = "VARCHAR(1) DEFAULT 'A'")
    @Enumerated(EnumType.STRING)
    @NotNull
    private ERecordStatus recordStatus = ERecordStatus.A;

}