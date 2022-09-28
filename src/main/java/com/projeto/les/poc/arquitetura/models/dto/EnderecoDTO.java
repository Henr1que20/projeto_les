package com.projeto.les.poc.arquitetura.models.dto;

import com.projeto.les.poc.arquitetura.models.domain.Cidade;
import com.projeto.les.poc.arquitetura.models.domain.Cliente;
import com.projeto.les.poc.arquitetura.models.domain.Endereco;

public class EnderecoDTO {

    private Long id;

    private String logradouro;
    private String numero;
    private String bairro;
    private String cep;
    private String pais;

    //private Cidade cidade;

    private boolean salvar;

    public void mapper(Endereco dominio, Cliente cliente) {
        Cidade cidade = new Cidade();
        //cidade.setId(this.cidade.getId());

        if(!this.salvar){
            cliente = null;
        }

       dominio.atualizarDados(logradouro, bairro, numero, cep, pais, cliente);
    }

    public static EnderecoDTO from(Endereco endereco) {
        EnderecoDTO dto = new EnderecoDTO();

        dto.id = endereco.getId();
        dto.logradouro = endereco.getLogradouro();
        dto.numero = endereco.getNumero();
        dto.bairro = endereco.getBairro();
        //dto.cidade = endereco.getCidade();
        dto.pais = endereco.getPais();
        dto.cep = endereco.getCep();

        return dto;
    }
}
