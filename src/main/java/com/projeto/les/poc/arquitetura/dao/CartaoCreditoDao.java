package com.projeto.les.poc.arquitetura.dao;

import com.projeto.les.poc.arquitetura.models.domain.CartaoCredito;
import com.projeto.les.poc.arquitetura.models.domain.Cliente;
import com.projeto.les.poc.arquitetura.models.domain.EntidadeDominio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Repository
@Service
public interface CartaoCreditoDao extends JpaRepository<CartaoCredito, Long>, IDAO{
    @Override
    default EntidadeDominio salvar(EntidadeDominio entidade){
        return this.saveAndFlush((CartaoCredito) entidade);
    }

    @Override
    default EntidadeDominio alterar(EntidadeDominio entidade){
        return this.saveAndFlush((CartaoCredito) entidade);
    }

    @Override
    default boolean consultar(EntidadeDominio entidadeDominio){
        return false;
    }
}
