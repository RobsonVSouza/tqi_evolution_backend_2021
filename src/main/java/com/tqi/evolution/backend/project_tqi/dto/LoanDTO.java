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
public class LoanDTO {

    private Long id;
    private Long clientId;
    private Double requestedAmount; // valor do emprestimo
    private Instant firstInstallment;
    private Double installmentValue; // valor da parcela
    private LoanStatus status;
    private String message;
    private Integer installmentsQuantity; // quantidade de parcela
    private Double loanWithInterest;

}
