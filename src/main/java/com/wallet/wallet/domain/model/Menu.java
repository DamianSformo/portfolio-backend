package com.wallet.wallet.domain.model;

import com.wallet.wallet.domain.enums.ERecordStatus;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "menu")
@Data
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
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date recordUpdate;

    @Column(name = "record_status", nullable = false, columnDefinition = "VARCHAR(2) DEFAULT 'A'")
    @Enumerated(EnumType.STRING)
    @NotNull
    private ERecordStatus recordStatus = ERecordStatus.A;

}