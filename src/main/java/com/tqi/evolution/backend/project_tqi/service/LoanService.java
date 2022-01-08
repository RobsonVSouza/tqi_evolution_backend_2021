package com.tqi.evolution.backend.project_tqi.service;

import com.tqi.evolution.backend.project_tqi.entity.Client;
import com.tqi.evolution.backend.project_tqi.entity.Loan;
import com.tqi.evolution.backend.project_tqi.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoanService {


    @Autowired
    private ClientRepository clientRepository;

    public Loan simulate(Loan loan) {

        Client client = clientRepository.getById(loan.getClientId().get(0));

        Integer parcelAmount = loan.getParcelAmount();
        Double amount = loan.getAmount();

        Double income = client.getIncome();

        Double minimum = income * 30 / 100;
        Double interestRate = parcelAmount * 0.01;
        Double fees = amount * interestRate;
        Double total = amount + fees;
        Double installmentAmount = total / parcelAmount;


        if (parcelAmount <= 3 && installmentAmount <= minimum) {
            System.out.printf("Loan sem juros : %.2f \n", amount);
            System.out.printf("valor da parcela : %.2f\n ", amount / parcelAmount);
        } else if (parcelAmount <= 3 && installmentAmount > minimum) {
            System.out.println("Não é possivel valordo emprestimo, parcela exede 30% da renda");
        }
        if (parcelAmount > 4 && installmentAmount > minimum) {
            System.out.println("Não é possivel valor do emprestimo, parcela exede 20% da renda");
        } else if (parcelAmount > 4 && installmentAmount <= minimum) {
            System.out.printf("Taxa de juros : %.2f %%\n", interestRate);
            System.out.printf("Loan solicitado %.2f%%\n", amount);
            System.out.printf("juros a ser pago %.2f%%\n", fees);
            System.out.printf("valor total a ser pago %.2f%%\n", total);
            System.out.printf("Valor das parcelas é %.2f%%\n", installmentAmount);

        }
        return null;
    }




}
