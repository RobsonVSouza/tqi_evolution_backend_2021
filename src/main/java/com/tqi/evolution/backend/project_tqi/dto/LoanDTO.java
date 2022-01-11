package com.tqi.evolution.backend.project_tqi.dto;


import com.tqi.evolution.backend.project_tqi.constant.LoanStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoanDTO {

    private Long id;

    private Long clientId;

    @Min(value = 1, message = "Valor do emprestimo deve ser maior que 0")
    private Double requestedAmount; // valor do emprestimo

    private Instant firstInstallment;

    private Double installmentValue; // valor da parcela
    private LoanStatus status;
    private String message;

    @Min(value = 1, message = "numero de parcelas deve ser maior ou igual a 1")
    @Max(value = 60,message = "numero de parcela não pode ser menor que 60")
    private Integer installmentsQuantity; // quantidade de parcela
    private Double loanWithInterest;

}
