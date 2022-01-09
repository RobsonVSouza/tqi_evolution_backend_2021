package com.tqi.evolution.backend.project_tqi.constant;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum LoanStatus {

    APPROVED("Emprestimo aprovado"),
    REJECT("Emprestimo negado");

    private final String description;
}
