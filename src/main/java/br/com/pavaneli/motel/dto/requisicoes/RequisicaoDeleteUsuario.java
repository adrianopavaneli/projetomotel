package br.com.pavaneli.motel.dto.requisicoes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequisicaoDeleteUsuario {
	
	private String idUsuario;
	
	
	
	public String toUsuario() {
		String id = idUsuario;
		return id;
	}

}
