package br.com.pavaneli.motel.dto.requisicoes;

import br.com.pavaneli.motel.entity.TipoQuarto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequisicaoNovoTipoQuarto {
	
	private String descricaoTipoQuarto;
	
	
	





	public TipoQuarto toTipoQuarto() {
		TipoQuarto tipoQuarto = new TipoQuarto();
		tipoQuarto.setDescricao(descricaoTipoQuarto);
		
		return tipoQuarto;
	}
	

}
