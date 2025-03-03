package com.portfolio.portfolio.domain.model;

import com.portfolio.portfolio.domain.enums.ERecordStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@Table(name = "prize", indexes = {
        @Index(name = "idx_record_status", columnList = "record_status")
})
public class Prize {

    @Id
    @SequenceGenerator(name = "prizeSequence", sequenceName = "prizeSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prizeSequence")
    private Long id;

    @NotNull
    private Integer year;

    @Column(name = "title_es")
    @NotNull
    private String titleEs;

    @Column(name = "title_en")
    @NotNull
    private String titleEn;

    @Column(name = "order_index")
    private Integer orderIndex;

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