package br.com.pavaneli.motel.dto.requisicoes;

import br.com.pavaneli.motel.entity.Usuario;
import br.com.pavaneli.motel.enums.TipoSituacaoUsuario;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequisicaoNovoUsuario {
	
	private String nomeUsuario;
	private String loginUsuario;
	private String senhaUsuario;
	private String emailUsuario;
	private String situacaoUsuario;
	
	

	

	public Usuario toUsuario() {
		Usuario usuario = new Usuario();
		usuario.setNome(nomeUsuario);
		usuario.setLogin(loginUsuario);
		usuario.setSenha(senhaUsuario);
		usuario.setEmail(emailUsuario);	
		usuario.setSituacao(TipoSituacaoUsuario.doValor(situacaoUsuario));
		return usuario;
	}
	

}
