package com.portfolio.portfolio.domain.model;

import com.portfolio.portfolio.domain.enums.ERecordStatus;
import com.portfolio.portfolio.domain.enums.ERole;
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
@Table(name = "user", indexes = {
        @Index(name = "idx_record_status", columnList = "record_status"),
})
public class User {

    @Id
    @SequenceGenerator(name = "userSequence",sequenceName = "userSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userSequence")
    private Long id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @Column(unique = true)
    @NotNull
    private String email;

    @NotNull
    private String password;

    @Enumerated(EnumType.STRING)
    @NotNull
    private ERole role;

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
