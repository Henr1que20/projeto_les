package com.projeto.les.poc.arquitetura.models.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor

@Getter
@Setter
@Entity
public class Endereco extends EntidadeDominio {

    private String logradouro;
    private String bairro;
    private String numero;
    private String cep;
    private String pais;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "cidade_id")
    private Cidade cidade;

    @JoinColumn(name = "cliente", foreignKey = @ForeignKey(name = "fk_endereco_cliente"))
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH})
    private Cliente cliente;

    public Endereco(Cliente cliente) {
        this.cliente = cliente;
    }

    public void atualizarDados(String logradouro, String bairro, String numero, String cep,
                              String pais, Cliente cliente) {
        //super.setId(id);
        super.setAtivo(true);
       // if (this.getId() == 0 || this.getId() == null) {
            super.setDataCriacao(LocalDateTime.now());
        //}
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.numero = numero;
        this.cep = cep;
        this.cliente = cliente;
        //this.cidade = cidade;
        this.pais = pais;
    }
}
