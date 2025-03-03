package com.portfolio.portfolio.domain.model;

import com.portfolio.portfolio.domain.enums.ERecordStatus;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "processing_file", indexes = {
        @Index(name = "idx_record_status", columnList = "record_status")
})
@Data
public class ProcessingFile {

    @Id
    @SequenceGenerator(name = "menuSequence", sequenceName = "menuSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "menuSequence")
    private Long id;

    @Column(name = "url_desktop", nullable = false)
    @NotNull
    private String urlDesktop;

    @Column(name = "url_mobile", nullable = false)
    @NotNull
    private String urlMobile;

    @Column(name = "record_update")
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date recordUpdate;

    @Column(name = "record_status", nullable = false, columnDefinition = "VARCHAR(2) DEFAULT 'A'")
    @Enumerated(EnumType.STRING)
    @NotNull
    private ERecordStatus recordStatus = ERecordStatus.A;

}