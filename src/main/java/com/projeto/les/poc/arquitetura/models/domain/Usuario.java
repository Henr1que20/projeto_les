package com.projeto.les.poc.arquitetura.models.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
public class Usuario extends EntidadeDominio {

    private String email;
    private String senha;

    public Usuario(String email, String senha) {
        super.setAtivo(true);
        if (this.getId() == null) {
            super.setDataCriacao(LocalDateTime.now());
        }
        this.email = email;
        this.senha = senha;
    }
}
