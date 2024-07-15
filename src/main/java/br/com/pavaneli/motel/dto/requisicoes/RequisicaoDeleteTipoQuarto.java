package br.com.pavaneli.motel.dto.requisicoes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequisicaoDeleteTipoQuarto {
	
	private String idTipoQuarto;
	
	
	
	


	public String toProduto() {
		String id = idTipoQuarto;
		return id;
	}

}
