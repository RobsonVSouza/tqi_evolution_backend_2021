package com.tqi.evolution.backend.project_tqi.controller;


import com.tqi.evolution.backend.project_tqi.entity.Loan;
import com.tqi.evolution.backend.project_tqi.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping(value = "/loan")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @PostMapping(value = "/newloan")
    public Loan simulateLoan(@RequestBody Loan loan){
        return loanService.simulate(loan);
    }

}
