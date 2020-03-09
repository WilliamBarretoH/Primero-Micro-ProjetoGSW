package com.gsw.PoC.service.implemetation;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsw.PoC.model.entity.Usuario;
import com.gsw.PoC.model.repository.UsuarioRepository;
import com.gsw.PoC.service.UsuarioService;
import com.gsw.PoC.service.validator.UsuarioValidator;

@Service
public class UsuarioImplemetation implements UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private UsuarioValidator usuarioValidator;
	
	@Override
	@Transactional
	public Usuario salvar(Usuario usuario) {
		usuarioValidator.validar(usuario);
		return usuarioRepository.save(usuario);
	}

	@Override
	public Optional<Usuario> obterPorId(Long id) {
		
		return usuarioRepository.findById(id);
	}

}
