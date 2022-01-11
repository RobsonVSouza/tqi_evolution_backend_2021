package com.tqi.evolution.backend.project_tqi.repository;


import com.tqi.evolution.backend.project_tqi.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LoanRepository extends JpaRepository <Loan , Long> {

    List<LoanRepository> findByClientId(Long clientId);

}
