package com.tqi.evolution.backend.project_tqi.repository;

import com.tqi.evolution.backend.project_tqi.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
