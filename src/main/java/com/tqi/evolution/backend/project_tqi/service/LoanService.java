package com.tqi.evolution.backend.project_tqi.service;

import com.tqi.evolution.backend.project_tqi.constant.LoanStatus;
import com.tqi.evolution.backend.project_tqi.dto.LoanDTO;
import com.tqi.evolution.backend.project_tqi.dto.SimpleLoanDTO;
import com.tqi.evolution.backend.project_tqi.entity.Client;
import com.tqi.evolution.backend.project_tqi.mapper.SimpleLoanMapper;
import com.tqi.evolution.backend.project_tqi.repository.ClientRepository;
import com.tqi.evolution.backend.project_tqi.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class LoanService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private SimpleLoanMapper simpleLoanMapper;


    public SimpleLoanDTO simulate(LoanDTO loan) {

        SimpleLoanDTO simpleLoanDTO = new SimpleLoanDTO();

        Client client = clientRepository.getById(loan.getClientId());
        if (client.getId() == null) {
            throw new EntityNotFoundException();
        }

        Integer installmentsQuantity = loan.getInstallmentsQuantity(); // quantidade de parcela

        Double requestedAmount = loan.getRequestedAmount(); // valor do emprestimo
        Double income = client.getIncome(); // renda do cliente

        Double minimum = income * 0.30;
        Double interestRate = installmentsQuantity * 0.01; // juros por parcela
        Double fees = requestedAmount * interestRate;
        Double loanWithInterest = requestedAmount + fees;
        Double installmentValue = loanWithInterest / installmentsQuantity;

        simpleLoanDTO.setRequestedAmount(requestedAmount);
        simpleLoanDTO.setInstallmentValue(installmentValue);
        simpleLoanDTO.setInstallmentsQuantity(installmentsQuantity);
        simpleLoanDTO.setLoanWithInterest(loanWithInterest);
        simpleLoanDTO.setFirstInstallment(loan.getFirstInstallment());

        if (installmentValue > minimum) {
            simpleLoanDTO.setStatus(LoanStatus.REJECT);
            simpleLoanDTO.setMessage("Não é possivel o emprestimo, valor da parcela exede 30% da renda");
        } else if (installmentValue <= minimum) {
            simpleLoanDTO.setStatus(LoanStatus.APPROVED);
            simpleLoanDTO.setMessage("Emprestimo aprovado!");
        }
        simpleLoanDTO.setCode(loanRepository.save(simpleLoanMapper.toEntity(simpleLoanDTO)).getId());

        return simpleLoanDTO;
    }




}
