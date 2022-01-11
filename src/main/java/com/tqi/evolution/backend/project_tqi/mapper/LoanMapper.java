package com.tqi.evolution.backend.project_tqi.mapper;

import com.tqi.evolution.backend.project_tqi.dto.DetailedLoanDTO;
import com.tqi.evolution.backend.project_tqi.dto.SimpleLoanDTO;
import com.tqi.evolution.backend.project_tqi.entity.Loan;
import org.springframework.stereotype.Component;

@Component
public class LoanMapper {

    public SimpleLoanDTO toSimpleLoanDTO(Loan loan) {
        SimpleLoanDTO simpleLoanDTO = new SimpleLoanDTO();
        simpleLoanDTO.setRequestedAmount(loan.getRequestedAmount());
        simpleLoanDTO.setInstallmentValue(loan.getInstallmentValue());
        simpleLoanDTO.setInstallmentsQuantity(loan.getInstallmentsQuantity());
        simpleLoanDTO.setStatus(loan.getStatus());
        simpleLoanDTO.setStatus(loan.getStatus());
        simpleLoanDTO.setMessage(loan.getMessage());
        simpleLoanDTO.setLoanWithInterest(loan.getLoanWithInterest());
        simpleLoanDTO.setFirstInstallment((loan.getFirstInstallment()));

        return simpleLoanDTO;
    }

    public DetailedLoanDTO toDetailedLoanDto(Loan loan) {
        DetailedLoanDTO detailedLoanDTO = new DetailedLoanDTO();
        detailedLoanDTO.setCode(loan.getId());
        detailedLoanDTO.setRequestedAmount(loan.getRequestedAmount());
        detailedLoanDTO.setLoanWithInterest(loan.getLoanWithInterest());
        detailedLoanDTO.setInstallmentValue(loan.getInstallmentValue());
        detailedLoanDTO.setInstallmentsQuantity(loan.getInstallmentsQuantity());
        detailedLoanDTO.setStatus(loan.getStatus());
        detailedLoanDTO.setMessage(loan.getMessage());
        detailedLoanDTO.setFirstInstallment((loan.getFirstInstallment()));
        detailedLoanDTO.setEmail(loan.getClient().getEmail());
        detailedLoanDTO.setIncome(loan.getClient().getIncome());

        return detailedLoanDTO;
    }

    public Loan simpleToEntity(SimpleLoanDTO simpleLoanDTO) {
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
