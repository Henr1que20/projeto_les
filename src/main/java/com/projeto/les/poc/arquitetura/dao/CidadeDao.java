package com.projeto.les.poc.arquitetura.dao;

import com.projeto.les.poc.arquitetura.models.domain.Cidade;
import com.projeto.les.poc.arquitetura.models.domain.EntidadeDominio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Repository
@Service
public interface CidadeDao  extends JpaRepository<Cidade, Long>, IDAO{
    @Override
    default EntidadeDominio salvar(EntidadeDominio entidade){
        return this.saveAndFlush((Cidade) entidade);
    }

    @Override
    default EntidadeDominio alterar(EntidadeDominio entidade){
        return this.saveAndFlush((Cidade) entidade);
    }

    @Override
    default boolean consultar(EntidadeDominio entidadeDominio){
        return false;
    }
}
