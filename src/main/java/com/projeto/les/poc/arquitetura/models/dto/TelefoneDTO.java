package com.projeto.les.poc.arquitetura.models.dto;

import com.projeto.les.poc.arquitetura.models.domain.Telefone;

public class TelefoneDTO {

    private Long id;
    private String telefone;

    public void mapper(Telefone dominio) {
        dominio.atualizarDados(this.telefone);
    }

    public static TelefoneDTO from(Telefone telefone){
        TelefoneDTO dto = new TelefoneDTO();
        dto.id = telefone.getId();
        dto.telefone = telefone.getTelefone();
        return dto;
    }

}
