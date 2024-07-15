package br.com.pavaneli.motel.dto.requisicoes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequisicaoDeleteQuarto {
	
	private String idQuarto;
	
	
	public String toQuarto() {
		String id = idQuarto;
		return id;
	}

}
