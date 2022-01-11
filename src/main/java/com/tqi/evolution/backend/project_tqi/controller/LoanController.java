package com.tqi.evolution.backend.project_tqi.controller;


import com.tqi.evolution.backend.project_tqi.dto.DetailedLoanDTO;
import com.tqi.evolution.backend.project_tqi.dto.LoanDTO;
import com.tqi.evolution.backend.project_tqi.dto.SimpleLoanDTO;
import com.tqi.evolution.backend.project_tqi.entity.Loan;
import com.tqi.evolution.backend.project_tqi.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/loan", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class LoanController {


    @Autowired
    private LoanService loanService;

    @PostMapping(value = "/simulate")
    public ResponseEntity<SimpleLoanDTO> simulateLoan(@Valid @RequestBody LoanDTO loan){
        return new ResponseEntity<>(loanService.simulate(loan), HttpStatus.OK);
    }

    @GetMapping(value = "/{loanId}", consumes = MediaType.ALL_VALUE)
    public ResponseEntity<SimpleLoanDTO> getById(@PathVariable Long loanId){
        return new ResponseEntity<>(loanService.findById(loanId),HttpStatus.OK);
    }

    @GetMapping(value = "/detailed/{loanId}", consumes = MediaType.ALL_VALUE)
    public ResponseEntity<DetailedLoanDTO> getByIdDetailed(@PathVariable Long loanId){
        return new ResponseEntity<>(loanService.findByIdDetailed(loanId),HttpStatus.OK);
    }
}
