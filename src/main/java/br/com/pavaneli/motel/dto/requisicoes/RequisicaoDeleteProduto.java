package br.com.pavaneli.motel.dto.requisicoes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequisicaoDeleteProduto {
	
	private String idProduto;
	
	
	
	public String toProduto() {
		String id = idProduto;
		return id;
	}

}
