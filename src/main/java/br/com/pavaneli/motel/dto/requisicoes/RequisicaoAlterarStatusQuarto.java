package br.com.pavaneli.motel.dto.requisicoes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequisicaoAlterarStatusQuarto {
    private String idQuarto;
    private String statusQuarto;
}