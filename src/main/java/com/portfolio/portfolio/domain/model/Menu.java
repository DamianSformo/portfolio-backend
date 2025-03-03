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
@Table(name = "menu", indexes = {
        @Index(name = "idx_record_status", columnList = "record_status")
})
public class Menu {

    @Id
    @SequenceGenerator(name = "menuSequence", sequenceName = "menuSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "menuSequence")
    private Long id;

    @Column(name = "title_es", nullable = false)
    @NotNull
    private String titleEs;

    @Column(name = "title_en", nullable = false)
    @NotNull
    private String titleEn;

    @Column(nullable = false)
    @NotNull
    private String router;

    @Column(name = "order_index", nullable = true)
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

    @Column(name = "record_status", nullable = false, columnDefinition = "VARCHAR(1) DEFAULT 'A'")
    @Enumerated(EnumType.STRING)
    @NotNull
    private ERecordStatus recordStatus = ERecordStatus.A;

}