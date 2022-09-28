package com.projeto.les.poc.arquitetura.controllers;

import com.projeto.les.poc.arquitetura.facade.IFacade;
import com.projeto.les.poc.arquitetura.models.domain.Cliente;
import com.projeto.les.poc.arquitetura.models.domain.Endereco;
import com.projeto.les.poc.arquitetura.models.domain.EntidadeDominio;
import com.projeto.les.poc.arquitetura.models.dto.ClienteDTO;
import com.projeto.les.poc.arquitetura.models.dto.EnderecoDTO;
import com.projeto.les.poc.arquitetura.models.utils.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/endereco")
public class EnderecoController {

    private final IFacade facade;

    @PostMapping(path = "{userId}")
    public ResponseEntity<EnderecoDTO> salvarEndereco(@PathVariable Long userId,
                                                      @RequestBody EnderecoDTO enderecoDTO) {

        Cliente cliente = new Cliente();
        cliente.setId(userId);
        if (facade.consultar(cliente)){
            Endereco endereco = new Endereco();
            enderecoDTO.mapper(endereco, cliente);

            EntidadeDominio clienteResultado = this.facade.salvar(cliente);

            return ResponseEntity.ok().body(enderecoDTO);
        }

        return ResponseEntity.badRequest().build();
    }
}
