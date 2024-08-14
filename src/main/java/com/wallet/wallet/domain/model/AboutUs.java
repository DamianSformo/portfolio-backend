package com.wallet.wallet.domain.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "aboutUs")
@Data
public class AboutUs {

    @Id
    @SequenceGenerator(name = "aboutUsSequence",sequenceName = "aboutUsSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aboutUsSequence")
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String nameComplete;

    @NotNull
    @Column(nullable = false)
    private String role;

    @NotNull
    @Column(nullable = false)
    private String description;

    @NotNull
    @Lob
    @Column(nullable = false)
    private String image;

    private String email;

    private String linkedIn;

    private String behance;

    private String github;


}
