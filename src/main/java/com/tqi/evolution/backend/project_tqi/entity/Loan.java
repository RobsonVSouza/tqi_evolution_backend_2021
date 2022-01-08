package com.tqi.evolution.backend.project_tqi.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.Instant;
import java.util.List;


@Getter
@Setter
@Entity
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToMany(targetEntity = Client.class)
    private List<Long> clientId;

    @Column
    private Double amount;

    @Column
    private Instant datePortion;

    @Column
    private Integer parcelAmount;


}
