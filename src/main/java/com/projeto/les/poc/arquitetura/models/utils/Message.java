package com.projeto.les.poc.arquitetura.models.utils;

import com.projeto.les.poc.arquitetura.models.domain.EntidadeDominio;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class Message {
    private String description;
    private String title;

    private EntidadeDominio dominio;
}
