package com.tqi.evolution.backend.project_tqi.entity;

import com.tqi.evolution.backend.project_tqi.constant.LoanStatus;
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

    @OneToOne(targetEntity = Client.class)
    private Client client;

    @Column
    private Double requestedAmount; //valor solicitado

    @Column
    private Instant firstInstallment; //data da primeira parcela

    @Column
    private Double installmentValue; //valor da parcela

    @Column
    private Integer installmentsQuantity; // quantidade de parcela

    @Column
    private Double loanWithInterest; // emprestimo + juros (valor total)

    @Column
    private String message; // resultado do emprestimo

    @Enumerated(value = EnumType.STRING)
    @Column
    private LoanStatus status;

}