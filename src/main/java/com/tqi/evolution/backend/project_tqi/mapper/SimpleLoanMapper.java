package com.tqi.evolution.backend.project_tqi.mapper;

import com.tqi.evolution.backend.project_tqi.dto.SimpleLoanDTO;
import com.tqi.evolution.backend.project_tqi.entity.Loan;
import org.springframework.stereotype.Component;

@Component
public class SimpleLoanMapper {

    public Loan toEntity(SimpleLoanDTO simpleLoanDTO) {
        Loan loan = new Loan();
        loan.setRequestedAmount(simpleLoanDTO.getRequestedAmount());
        loan.setInstallmentValue(simpleLoanDTO.getInstallmentValue());
        loan.setInstallmentsQuantity(simpleLoanDTO.getInstallmentsQuantity());
        loan.setStatus(simpleLoanDTO.getStatus());
        loan.setStatus(simpleLoanDTO.getStatus());
        loan.setMessage(simpleLoanDTO.getMessage());
        loan.setLoanWithInterest(simpleLoanDTO.getLoanWithInterest());
        loan.setFirstInstallment((simpleLoanDTO.getFirstInstallment()));

        return loan;
    }
}
