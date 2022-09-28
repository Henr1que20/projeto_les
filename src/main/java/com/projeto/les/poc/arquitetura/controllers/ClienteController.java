package com.projeto.les.poc.arquitetura.controllers;

import com.projeto.les.poc.arquitetura.facade.IFacade;
import com.projeto.les.poc.arquitetura.models.domain.Cliente;
import com.projeto.les.poc.arquitetura.models.domain.EntidadeDominio;
import com.projeto.les.poc.arquitetura.models.dto.ClienteDTO;
import com.projeto.les.poc.arquitetura.models.utils.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/clientes")
public class ClienteController {


    private final IFacade facade;

    //@PostMapping
//    public ResponseEntity<ClienteDTO> salvarCliente(@RequestBody ClienteDTO dto){
//
//        Cliente cliente = dto.from(dto);
//
//        EntidadeDominio entidade = this.facade.salvar(cliente);
//
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//                .buildAndExpand(entidade.getId()).toUri();
//
//        ClienteDTO clienteDto = dto.convert(cliente);
//
//        return ResponseEntity.created(uri).body(clienteDto);
//
//
//    }
//

    @PostMapping
    public ResponseEntity<Message> salvarCliente(
            @RequestBody ClienteDTO clienteDto) {
        try {

            Message message = new Message();
            Cliente cliente = new Cliente();
            clienteDto.mapper(cliente);

            EntidadeDominio clienteResultado = this.facade.salvar(cliente);




            if (clienteResultado == null) {
                Cliente clt = clienteDto.from(clienteDto);
                message.setTitle("Sucesso");
                message.setDescription("Cliente cadastrado com sucesso!");
                return ResponseEntity.ok(message);
            } else {
                message.setTitle("Erro");
                return ResponseEntity.badRequest().body(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }



}
