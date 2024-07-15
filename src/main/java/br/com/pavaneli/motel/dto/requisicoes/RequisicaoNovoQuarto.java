package br.com.pavaneli.motel.dto.requisicoes;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.pavaneli.motel.entity.Quarto;
import br.com.pavaneli.motel.entity.TipoQuarto;
import br.com.pavaneli.motel.enums.StatusQuarto;
import br.com.pavaneli.motel.repository.TipoQuartoRepository;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequisicaoNovoQuarto {
	private String numeroQuarto;
	private String descricaoQuarto;
	private String valorHoraQuarto;
	private String valorPernoiteQuarto;
	private String statusQuarto;
	private String tipoQuarto;
	private Long TipoQuartoId;
	
	@Autowired
	private TipoQuartoRepository tipoQuartoRepository;
	
	
	
	


		 public Quarto toQuarto(TipoQuartoRepository tipoQuartoRepository) {
		        Quarto quarto = new Quarto();
		        quarto.setNumero(Integer.parseInt(numeroQuarto));
		        quarto.setDescricao(descricaoQuarto);
		        quarto.setValorHora(Double.parseDouble(valorHoraQuarto));
		        quarto.setValorPernoite(Double.parseDouble(valorPernoiteQuarto));
		        quarto.setStatus(StatusQuarto.doValor(statusQuarto));

		        if (tipoQuarto != null && !tipoQuarto.isEmpty()) {
		            Long tipoQuartoId = Long.parseLong(tipoQuarto);
		            TipoQuarto tipoQuartoEntity = tipoQuartoRepository.findById(tipoQuartoId)
		                .orElseThrow(() -> new IllegalArgumentException("Tipo de quarto não encontrado"));
		            quarto.setTipoQuarto(tipoQuartoEntity);
		        }

		        return quarto;
		    }
	

}
