package com.tqi.evolution.backend.project_tqi.dto;

import com.tqi.evolution.backend.project_tqi.constant.LoanStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DetailedLoanDTO {

    private String email;
    private Double income;

    private Long code; // codigo do emprestimo
    private Double requestedAmount; // valor do emprestimo
    private Double installmentValue; // valor da parcela
    private Integer installmentsQuantity; // quantidade de parcela
    private LoanStatus status; // Status do emprestimo
    private String message; // resultado do emprestimo
    private Double loanWithInterest; // valor total com juros
    private Instant firstInstallment;
}
