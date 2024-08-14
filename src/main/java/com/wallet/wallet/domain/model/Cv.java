package com.wallet.wallet.domain.model;

import com.wallet.wallet.domain.enums.ERecordStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "project")
@Data
public class Cv {

    @Id
    @SequenceGenerator(name = "projectSequence", sequenceName = "projectSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "projectSequence")
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "record_update", nullable = true)
    //@NotNull
    private Date recordUpdate;

    @Column(name = "record_status", nullable = false, columnDefinition = "VARCHAR(2) DEFAULT 'A'")
    @Enumerated(EnumType.STRING)
    //@NotBlank
    private ERecordStatus recordStatus = ERecordStatus.A;

    //@OneToMany(mappedBy = "study", cascade = CascadeType.ALL, orphanRemoval = true)
    //@JsonIgnore
    //private List<Study> projectFiles;

    //@OneToMany(mappedBy = "exhibition", cascade = CascadeType.ALL, orphanRemoval = true)
    //@JsonIgnore
    //private List<Exhibition> projectFiles;

    //@OneToMany(mappedBy = "awards", cascade = CascadeType.ALL, orphanRemoval = true)
    //@JsonIgnore
    //private List<Awards> projectFiles;
}