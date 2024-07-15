package br.com.pavaneli.motel.dto.requisicoes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequisicaoAlterarQuarto {
    private String idQuarto;
    private String numeroQuarto;
    private String descricaoQuarto;
    private String valorHoraQuarto;
    private String valorPernoiteQuarto;
    private String statusQuarto;
    private Long tipoQuartoId;

    
}