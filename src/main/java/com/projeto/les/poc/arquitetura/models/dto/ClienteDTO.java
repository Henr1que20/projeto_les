package com.projeto.les.poc.arquitetura.models.dto;

import com.projeto.les.poc.arquitetura.models.domain.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class ClienteDTO {

    private Long id;
    private String nome;
    private String sobrenome;
    private LocalDate datNascimento;
    private String cpf;

    private String email;

    private String senha;

    private String confirmacaoSenha;

    private boolean ativo;

    private List<TelefoneDTO> telefones;

    //private List<EnderecoDTO> enderecos;

    //private List<CartaoCreditoDTO> cartoesCredito;


    public void mapper(Cliente dominio) {
        Usuario usuario;
        if (dominio.getUsuario() == null) {
            usuario = new Usuario(this.getEmail(), this.getSenha());
        } else {
            usuario = dominio.getUsuario();
        }
        List<Endereco> enderecoList = new ArrayList<>();
        List<Telefone> telefoneList = new ArrayList<>();
        List<CartaoCredito> cartoesList = new ArrayList<>();

//        if (this.getEnderecos() != null && !this.getEnderecos().isEmpty()) {
//            Endereco endereco = new Endereco();
//            for (EnderecoDTO enderecoDTO : this.getEnderecos()) {
//                enderecoDTO.mapper(endereco, dominio);
//            }
//            enderecoList.add(endereco);
//        }

        if (this.getTelefones() != null && !this.getTelefones().isEmpty()) {
            Telefone telefone = new Telefone(dominio);
            for (TelefoneDTO telefoneDTO : this.getTelefones()) {
                telefoneDTO.mapper(telefone);
            }
            telefoneList.add(telefone);
        }

//        if (this.getCartoesCredito() != null && !this.getCartoesCredito().isEmpty()) {
//            for (CartaoCreditoDTO cartaoCreditoDTO : this.getCartoesCredito()) {
//                CartaoCredito cartaoCredito = new CartaoCredito(dominio);
//                cartaoCreditoDTO.mapper(cartaoCredito);
//                cartoesList.add(cartaoCredito);
//            }
//        }

        dominio.atualizarDados(this.nome, this.sobrenome, this.datNascimento, this.cpf,
                telefoneList, usuario);
    }



    public Cliente from(ClienteDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setSobrenome(dto.getSobrenome());
        cliente.setDatNascimento(dto.getDatNascimento());
        cliente.setCpf(dto.getCpf());
        return cliente;
    }

    public ClienteDTO convert(Cliente cliente) {
        ClienteDTO dto = new ClienteDTO();
        dto.setId(cliente.getId());
        dto.setNome(cliente.getNome());
        dto.setSobrenome(cliente.getSobrenome());
        dto.setDatNascimento(cliente.getDatNascimento());
        dto.setCpf(cliente.getCpf());
        return dto;
    }
}
