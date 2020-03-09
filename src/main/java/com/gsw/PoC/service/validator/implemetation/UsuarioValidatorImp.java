package com.gsw.PoC.service.validator.implemetation;

import com.gsw.PoC.exception.RegraNegocioException;
import com.gsw.PoC.model.entity.Lancamento;
import com.gsw.PoC.service.validator.LancamentoValidator;

public class UsuarioValidatorImp implements LancamentoValidator {

	@Override
	public void validar(Lancamento lancamento) {
		if (lancamento.getUsuario() == null || lancamento.getUsuario().getId() == null) {
			throw new RegraNegocioException("informe um usuario valido");
		}		
	}

}
