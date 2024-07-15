package br.com.pavaneli.motel.dto.requisicoes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequisicaoCancelarHospedagem {
	
	private String idHospedagem;
	
	
	
	public String toHospedagem() {
		String id = idHospedagem;
		return id;
	}

}
