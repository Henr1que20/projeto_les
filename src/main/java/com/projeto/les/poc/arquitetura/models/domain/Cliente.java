package com.projeto.les.poc.arquitetura.models.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "cliente")
public class Cliente extends EntidadeDominio{

    private String nome;

    private String sobrenome;

    private LocalDate datNascimento;

    private String cpf;

    @OneToOne(cascade = CascadeType.ALL)
    private Usuario usuario;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    @Where(clause = "ativo = true")
    @OrderBy(value = "id")
    private List<Endereco> enderecos;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    @Where(clause = "ativo = true")
    @OrderBy(value = "id")
    private List<Telefone> telefones;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    @OrderBy(value = "id")
    private List<CartaoCredito> cartoesCredito;


    public void atualizarDados(String nome, String sobrenome, LocalDate dataNascimento, String cpf, List<Telefone> telefones, Usuario usuario) {
        ///super.setId(id);
        super.setAtivo(true);
        //if (this.getId() == 0 || this.getId() == null) {
            super.setDataCriacao(LocalDateTime.now());
        //}
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.datNascimento = dataNascimento;
        this.cpf = cpf;
        this.usuario = usuario;
        this.enderecos = enderecos;
        this.telefones = telefones;
        this.cartoesCredito = cartoesCredito;
    }
}
