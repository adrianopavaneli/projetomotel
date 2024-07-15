package br.com.pavaneli.motel.dto.requisicoes;

import br.com.pavaneli.motel.entity.TipoQuarto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequisicaoAlterarTipoQuarto {
private String idTipoQuarto;	
private String descricaoTipoQuarto;
	
	
	


	public TipoQuarto toTipoQuarto() {
		TipoQuarto tipoQuarto = new TipoQuarto();
		if (idTipoQuarto != null && !idTipoQuarto.isEmpty()) {
			tipoQuarto.setId(Long.parseLong(idTipoQuarto));
		}
		tipoQuarto.setDescricao(descricaoTipoQuarto);
		
		return tipoQuarto;
	}
	

}
