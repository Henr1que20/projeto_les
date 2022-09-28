package com.projeto.les.poc.arquitetura.models.dto;

import com.projeto.les.poc.arquitetura.models.domain.CartaoCredito;

public class CartaoCreditoDTO {

    private Long id;
    private String bandeira;
    private Boolean isPreferencial;
    private String codigoSeguranca;
    private String nomeImpressoCartao;
    private String numeroCartao;
    private boolean salvar;

    public void mapper(CartaoCredito dominio) {
        dominio.atualizarDados(this.bandeira, this.codigoSeguranca, this.nomeImpressoCartao, this.numeroCartao,
                this.isPreferencial, this.salvar);
    }

    public static CartaoCreditoDTO from(CartaoCredito cartaoCredito) {
        CartaoCreditoDTO dto = new CartaoCreditoDTO();
        dto.id = cartaoCredito.getId();
        dto.bandeira = cartaoCredito.getBandeira();
        dto.isPreferencial = cartaoCredito.isPreferencial();
        dto.codigoSeguranca = cartaoCredito.getCodigoSeguranca();
        dto.nomeImpressoCartao = cartaoCredito.getNomeImpressoCartao();
        dto.numeroCartao = cartaoCredito.getNumeroCartao();
        dto.salvar = cartaoCredito.isSalvar();
        return dto;
    }
}
