package com.tqi.evolution.backend.project_tqi.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String name;

    @Column(unique = true)
    private String email;

    @JsonProperty (access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Column
    private String cpf;

    @Column
    private String rg;

    @Column
    private String address;

    @Column
    private Double income;










}
