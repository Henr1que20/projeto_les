package com.projeto.les.poc.arquitetura.facade;

import com.projeto.les.poc.arquitetura.models.domain.EntidadeDominio;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public interface IFacade {

    EntidadeDominio salvar(EntidadeDominio entidade);

    String alterar(EntidadeDominio entidade);

    Optional<Object> consultar(Long id, EntidadeDominio entidadeDominio);

    boolean consultar(EntidadeDominio id);

    String excluir(EntidadeDominio entidade);
}
