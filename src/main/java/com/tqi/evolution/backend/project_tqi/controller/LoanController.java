package com.tqi.evolution.backend.project_tqi.controller;


import com.tqi.evolution.backend.project_tqi.dto.LoanDTO;
import com.tqi.evolution.backend.project_tqi.dto.SimpleLoanDTO;
import com.tqi.evolution.backend.project_tqi.entity.Loan;
import com.tqi.evolution.backend.project_tqi.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/loan")
public class LoanController {


    @Autowired
    private LoanService loanService;

    @PostMapping(value = "/simulate")
    public ResponseEntity<SimpleLoanDTO> simulateLoan(@RequestBody LoanDTO loan){
        return new ResponseEntity<>(loanService.simulate(loan), HttpStatus.OK);
    }

}
