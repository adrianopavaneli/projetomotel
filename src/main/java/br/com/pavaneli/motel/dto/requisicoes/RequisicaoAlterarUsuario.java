package br.com.pavaneli.motel.dto.requisicoes;

import br.com.pavaneli.motel.entity.Usuario;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class RequisicaoAlterarUsuario {
	private String idUsuario;
	private String nomeUsuario;
	private String loginUsuario;
	private String senhaUsuario;
	private String emailUsuario;

	
	public Usuario toUsuario() {
		Usuario usuario = new Usuario();
		if (idUsuario != null && !idUsuario.isEmpty()) {
			usuario.setId(Long.parseLong(idUsuario));
		}
		usuario.setNome(nomeUsuario);
		usuario.setLogin(loginUsuario);
		usuario.setSenha(senhaUsuario);
		usuario.setEmail(emailUsuario);
		return usuario;
	}

}
