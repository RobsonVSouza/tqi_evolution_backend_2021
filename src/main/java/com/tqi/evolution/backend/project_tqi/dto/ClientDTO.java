package com.tqi.evolution.backend.project_tqi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {

    private Long id;
    private String name;
    private String email;
    private String password;
    private String cpf;
    private String rg;
    private String address;
    private Double income;

}
