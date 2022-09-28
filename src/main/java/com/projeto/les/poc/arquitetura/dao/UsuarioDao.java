package com.projeto.les.poc.arquitetura.dao;

import com.projeto.les.poc.arquitetura.models.domain.EntidadeDominio;
import com.projeto.les.poc.arquitetura.models.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Repository
@Service
public interface UsuarioDao  extends JpaRepository<Usuario, Long>, IDAO{
    @Override
    default EntidadeDominio salvar(EntidadeDominio entidade){
        return this.saveAndFlush((Usuario) entidade);
    }

    @Override
    default EntidadeDominio alterar(EntidadeDominio entidade){
        return this.saveAndFlush((Usuario) entidade);
    }

    @Override
    default boolean consultar(EntidadeDominio entidadeDominio){
        return false;
    }
}
