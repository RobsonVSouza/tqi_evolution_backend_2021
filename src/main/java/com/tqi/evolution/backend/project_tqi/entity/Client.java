package com.tqi.evolution.backend.project_tqi.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    @NotBlank(message = "Nome nome nao pode ser vazio")
    private String name;

    @Column(unique = true)
    @Pattern(regexp=".+@.+\\..+", message="email deve ser valido")
    private String email;

    @JsonProperty (access = JsonProperty.Access.WRITE_ONLY)
    @NotBlank(message = "Senha nao pode ser vazio")
    private String password;

    @Column
    @NotBlank(message = "Cpf nao pode ser vazio")
    private String cpf;

    @Column
    @NotBlank(message = "Rg nao pode ser vazio")
    private String rg;

    @Column
    @NotBlank(message = "Endereço nao pode ser nulo ou vazio")
    private String address;

    @Column
    @Min(value =1, message = "Salario deve ser maior que 0")
    private Double income;

}
