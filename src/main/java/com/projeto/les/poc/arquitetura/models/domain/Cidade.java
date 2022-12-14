package com.projeto.les.poc.arquitetura.models.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@NoArgsConstructor

@Getter
@Setter
@Entity
public class Cidade extends EntidadeDominio{

    private String nome;
}
