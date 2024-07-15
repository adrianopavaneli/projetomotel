package br.com.pavaneli.motel.dto.requisicoes;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.pavaneli.motel.entity.Hospedagem;
import br.com.pavaneli.motel.entity.Quarto;
import br.com.pavaneli.motel.enums.StatusHospedagem;
import br.com.pavaneli.motel.enums.StatusQuarto;
import br.com.pavaneli.motel.repository.HospedagemRepository;
import br.com.pavaneli.motel.repository.ItemPedidoRepository;
import br.com.pavaneli.motel.repository.ProdutoRepository;
import br.com.pavaneli.motel.repository.QuartoRepository;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequisicaoFecharHospedagem {

	private String idHospedagem;
    private String horainicial;
    private String horafinal;
    private String obsHospedagem;
    private String placaHospedagem;
    private String descricaoHospedagem;
    private String valorHospedagem;
    private String valorTotalHospedagem;
    private String statusHospedagem;
    private String statusQuarto;
    private Long quartoHospedagem;

    @Autowired
    private HospedagemRepository hospedagemRepository;
    @Autowired
    private ItemPedidoRepository itemPedidoRepository;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private QuartoRepository quartoRepository;

    public Hospedagem toHospedagem(QuartoRepository quartoRepository) {
        Hospedagem hospedagem = new Hospedagem();
        if (idHospedagem != null && !idHospedagem.isEmpty()) {
            hospedagem.setId(Long.parseLong(idHospedagem));
        }
        hospedagem.setPlaca(placaHospedagem);
        hospedagem.setDescricao(descricaoHospedagem);
        hospedagem.setValor_hospedagem(Double.parseDouble(valorHospedagem));
        hospedagem.setValor_total(Double.parseDouble(valorTotalHospedagem));
        hospedagem.setObs(obsHospedagem);
        hospedagem.setStatus(StatusHospedagem.doValor(statusHospedagem));
        if (quartoHospedagem != null) {
            Quarto quarto = quartoRepository.findById(quartoHospedagem)
                    .orElseThrow(() -> new IllegalArgumentException("Quarto não encontrado"));
            hospedagem.setQuarto(quarto);
            quarto.setStatus(StatusQuarto.doValor(statusQuarto));
        }

        return hospedagem;
    }
}