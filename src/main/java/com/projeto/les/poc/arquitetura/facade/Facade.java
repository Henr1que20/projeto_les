package com.projeto.les.poc.arquitetura.facade;

import com.projeto.les.poc.arquitetura.dao.*;
import com.projeto.les.poc.arquitetura.models.domain.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class Facade implements IFacade{

    private Map<String, IDAO> daos = new HashMap<>();

    public Facade(ClienteDao clienteDao, EnderecoDao enderecoDao, CartaoCreditoDao cartaoCreditoDao,
                  CidadeDao cidadeDao, TelefoneDao telefoneDao, UsuarioDao usuarioDao){

        daos.put(Cliente.class.getName(), clienteDao);

        daos.put(Endereco.class.getName(), enderecoDao);

        daos.put(CartaoCredito.class.getName(), cartaoCreditoDao);

        daos.put(Cidade.class.getName(), cidadeDao);

        daos.put(Telefone.class.getName(), telefoneDao);

        daos.put(UsuarioDao.class.getName(), usuarioDao);
    }


    @Override
    public EntidadeDominio salvar(EntidadeDominio entidade) {
        entidade = daos.get(entidade.getClass().getName()).salvar(entidade);
        return entidade;
    }

    @Override
    public String alterar(EntidadeDominio entidade) {
        return null;
    }

    @Override
    public Optional<Object> consultar(Long id, EntidadeDominio entidadeDominio) {
        return Optional.empty();
    }


    @Override
    public boolean consultar(EntidadeDominio entidade) {
        return daos.get(entidade.getClass().getName()).consultar(entidade);
    }


    @Override
    public String excluir(EntidadeDominio entidade) {
        return null;
    }
}
