package com.gsw.PoC.controller.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gsw.PoC.controller.builder.UsuarioBuilder;
import com.gsw.PoC.controller.dto.UsuarioDTO;
import com.gsw.PoC.exception.RegraNegocioException;
import com.gsw.PoC.model.entity.Usuario;
import com.gsw.PoC.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioResource {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private UsuarioBuilder usuarioBuilder;
	
	@PostMapping("/salvar")
	public ResponseEntity salvar(@RequestBody UsuarioDTO usuarioDTO) {
//		Usuario usuario = Usuario.builder().nome(usuarioDTO.getNome()).email(usuarioDTO.getEmail())
//				.build();
		
		Usuario usuario = usuarioBuilder.builder(usuarioDTO);

		try {
			Usuario usuarioSalvo = usuarioService.salvar(usuario);
			return new ResponseEntity(usuarioSalvo, HttpStatus.CREATED);
		} catch (RegraNegocioException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}
}
