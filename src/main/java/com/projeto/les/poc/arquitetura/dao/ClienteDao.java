package com.projeto.les.poc.arquitetura.dao;

import com.projeto.les.poc.arquitetura.models.domain.Cliente;
import com.projeto.les.poc.arquitetura.models.domain.Endereco;
import com.projeto.les.poc.arquitetura.models.domain.EntidadeDominio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
@Service
public interface ClienteDao extends JpaRepository<Cliente, Long>, IDAO {

    @Override
    default EntidadeDominio salvar(EntidadeDominio entidade){
        return this.saveAndFlush((Cliente) entidade);
    }

    @Override
    default EntidadeDominio alterar(EntidadeDominio entidade){
        return this.saveAndFlush((Cliente) entidade);
    }

//    @Override
//    default Optional<EntidadeDominio> consultarByID(Long id, EntidadeDominio entidadeDominio){
//        Optional<E> cliente = findById(entidadeDominio.getId());
//
//        return cliente;
//
//    }


    @Query("SELECT " +
            "   obj " +
            "FROM " +
            "   #{#entityName} obj " +
            "WHERE " +
            "   (?#{[0].ativo} IS NOT NULL AND obj.ativo = TRUE) " +
            "   OR (?#{[0].nome} IS NOT NULL AND (UPPER(obj.nome) LIKE(CONCAT('%', UPPER(?#{[0].nome}),'%')))) " +
            "   OR (?#{[0].cpf} IS NOT NULL AND (UPPER(obj.cpf) LIKE(CONCAT('%', UPPER(?#{[0].cpf}),'%')))) " +
            "   OR (?#{[0].sobrenome} IS NOT NULL AND (UPPER(obj.sobrenome) LIKE(CONCAT('%', UPPER(?#{[0].sobrenome}),'%')))) " +
            "")
    List<EntidadeDominio> consultarTabela(@Param("dominio") EntidadeDominio entidadeDominio);


    @Query("SELECT " +
            "   obj " +
            "FROM " +
            "   #{#entityName} obj " +
            "WHERE " +
            "   obj.usuario.id = :usuarioId" +
            "")
    Cliente consultarUsuarioId(@Param("usuarioId") Integer usuarioId);

    @Override
    default boolean consultar(EntidadeDominio entidadeDominio) {

        Optional<Cliente> cliente = Optional.ofNullable((Cliente) entidadeDominio);
        cliente = findById(entidadeDominio.getId());

        if(cliente.isEmpty()){
            return false;
        }

        return true;

    }
}
