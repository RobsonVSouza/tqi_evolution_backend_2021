package com.tqi.evolution.backend.project_tqi.service;

import com.tqi.evolution.backend.project_tqi.constant.LoanStatus;
import com.tqi.evolution.backend.project_tqi.dto.DetailedLoanDTO;
import com.tqi.evolution.backend.project_tqi.dto.LoanDTO;
import com.tqi.evolution.backend.project_tqi.dto.SimpleLoanDTO;
import com.tqi.evolution.backend.project_tqi.entity.Client;
import com.tqi.evolution.backend.project_tqi.entity.Loan;
import com.tqi.evolution.backend.project_tqi.exception.ArgumentNotValidException;
import com.tqi.evolution.backend.project_tqi.mapper.LoanMapper;
import com.tqi.evolution.backend.project_tqi.repository.ClientRepository;
import com.tqi.evolution.backend.project_tqi.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class LoanService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private LoanMapper loanMapper;

    public List<LoanRepository> findByClientId(Long id){
        return loanRepository.findByClientId(id);
    }

    public SimpleLoanDTO findById(Long id){
        return loanMapper.toSimpleLoanDTO(loanRepository.getById(id));
    }

    public DetailedLoanDTO findByIdDetailed(Long id){
        return loanMapper.toDetailedLoanDto(loanRepository.getById(id));
    }

    public SimpleLoanDTO simulate(LoanDTO loan) {
        validate(loan);

        SimpleLoanDTO simpleLoanDTO = new SimpleLoanDTO();

        Client client = clientRepository.getById(loan.getClientId());
        if (client.getId() == null) {
            throw new EntityNotFoundException();
        }

        Integer installmentsQuantity = loan.getInstallmentsQuantity(); // quantidade de parcela

        Double requestedAmount = loan.getRequestedAmount(); // valor do emprestimo
        Double income = client.getIncome(); // renda do cliente

        Double minimum = income * 0.30 ;
        Double interestRate = installmentsQuantity * 0.01 ; // juros por parcela
        Double fees = requestedAmount * interestRate ;
        Double loanWithInterest = requestedAmount + fees ;
        Double installmentValue = loanWithInterest / installmentsQuantity ;

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
        Loan loanEntity = loanMapper.simpleToEntity(simpleLoanDTO);
        loanEntity.setClient(client);
        simpleLoanDTO.setCode(loanRepository.save(loanEntity).getId());

        return simpleLoanDTO;
    }

    private void validate(LoanDTO loan) {
        Instant date = loan.getFirstInstallment();
        if(date.isBefore(Instant.now())) {
            throw new ArgumentNotValidException("a data da primeira parcela pode ser menor que a data atual");
        }
        if (date.isAfter(Instant.now().plus(90, ChronoUnit.DAYS))) {
            throw new ArgumentNotValidException("a data do primeiro pagamento nao pode exceder 3 meses da data de contratacao");
        }
    }





}
