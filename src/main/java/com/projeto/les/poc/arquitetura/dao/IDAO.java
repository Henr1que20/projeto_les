package com.projeto.les.poc.arquitetura.dao;

import com.projeto.les.poc.arquitetura.models.domain.Cliente;
import com.projeto.les.poc.arquitetura.models.domain.EntidadeDominio;

import java.util.List;
import java.util.Optional;

public interface IDAO {

    EntidadeDominio salvar(EntidadeDominio entidade);

    EntidadeDominio alterar(EntidadeDominio entidade);

    //List<EntidadeDominio> consultar(EntidadeDominio entidade);

    //EntidadeDominio consultarByID(Long id, EntidadeDominio entidadeDominio);

    boolean consultar(EntidadeDominio entidadeDominio);

    //void excluir(EntidadeDominio entidade);
}
