package br.com.pavaneli.motel.dto.requisicoes;

import java.time.Instant;
import java.util.Date;

import br.com.pavaneli.motel.entity.Hospedagem;
import br.com.pavaneli.motel.entity.Quarto;
import br.com.pavaneli.motel.enums.StatusHospedagem;
import br.com.pavaneli.motel.enums.StatusQuarto;
import br.com.pavaneli.motel.repository.QuartoRepository;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequisicaoNovaHospedagem {
    private String placaHospedagem;
    private String descricaoHospedagem;
    private String observacaoHospedagem;
    private Long quartoId; // Renomeie para quartoId para corresponder ao nome do campo no formulário
    private String statusHospedagem;
    private String statusQuarto;

    public Hospedagem toHospedagem(QuartoRepository quartoRepository) {
        Hospedagem hospedagem = new Hospedagem();
        hospedagem.setPlaca(placaHospedagem);
        hospedagem.setDescricao(descricaoHospedagem);
        hospedagem.setObs(observacaoHospedagem);
        hospedagem.setStatus(StatusHospedagem.doValor(statusHospedagem));

        Instant now = Instant.now();
        Date checkinDate = Date.from(now);
        hospedagem.setCheckin(checkinDate);

        if (quartoId != null) {
            Quarto quarto = quartoRepository.findById(quartoId)
                    .orElseThrow(() -> new IllegalArgumentException("Quarto não encontrado"));
            hospedagem.setQuarto(quarto);
            quarto.setStatus(StatusQuarto.doValor(statusQuarto));
        }

        return hospedagem;
    }
    
    @Override
    public String toString() {
        return "RequisicaoNovaHospedagem{" +
            "placaHospedagem='" + placaHospedagem + '\'' +
            ", descricaoHospedagem='" + descricaoHospedagem + '\'' +
            ", observacaoHospedagem='" + observacaoHospedagem + '\'' +
            ", quartoId=" + quartoId +
            ", statusHospedagem='" + statusHospedagem + '\'' +
            ", statusQuarto='" + statusQuarto + '\'' +
            '}';
    }
}