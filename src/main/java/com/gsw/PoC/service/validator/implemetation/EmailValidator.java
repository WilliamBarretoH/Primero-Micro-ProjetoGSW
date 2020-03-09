package com.gsw.PoC.service.validator.implemetation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsw.PoC.exception.RegraNegocioException;
import com.gsw.PoC.model.entity.Usuario;
import com.gsw.PoC.model.repository.UsuarioRepository;
import com.gsw.PoC.service.validator.UsuarioValidator;

@Service
public class EmailValidator implements UsuarioValidator {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public void validar(Usuario usuario) {
		boolean existe = usuarioRepository.existsByEmail(usuario.getEmail());
		if (existe) {
			throw new RegraNegocioException("Já existe um usuario com esse email");
		}
	}

}
