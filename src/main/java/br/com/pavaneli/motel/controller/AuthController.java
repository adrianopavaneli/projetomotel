package br.com.pavaneli.motel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.pavaneli.motel.dto.AcessDTO;
import br.com.pavaneli.motel.dto.AuthenticationDTO;
import br.com.pavaneli.motel.dto.UsuarioDTO;
import br.com.pavaneli.motel.service.AuthService;
import br.com.pavaneli.motel.service.UsuarioService;

@Controller
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

	@Autowired
	private AuthService authService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/login")
    public String loginPage() {
        return "login";  // Retorna o nome da página login.html
    }
	
	@PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationDTO authDto) {
        AcessDTO accessDto = authService.login(authDto);
        return ResponseEntity.ok(accessDto);
    }
	
	@PostMapping(value = "/novoUsuario")
	public void inserirNovoUsuario(@RequestBody UsuarioDTO novoUsuario){
		usuarioService.inserirNovoUsuario(novoUsuario);
	}
	@GetMapping(value = "/verificarCadastro/{uuid}")
	public String verificarCadastro(@PathVariable("uuid") String uuid) {
		return usuarioService.verificarCadastro(uuid);
	}
	
}
