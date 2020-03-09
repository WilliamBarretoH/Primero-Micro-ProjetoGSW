package com.gsw.PoC.service;

import java.util.Optional;

import com.gsw.PoC.model.entity.Usuario;

public interface UsuarioService {

	Usuario salvar(Usuario usuario);
	
	Optional<Usuario> obterPorId(Long id);
}
