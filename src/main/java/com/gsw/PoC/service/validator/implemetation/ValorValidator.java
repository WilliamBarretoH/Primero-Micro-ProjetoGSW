package com.gsw.PoC.service.validator.implemetation;

import java.math.BigDecimal;

import com.gsw.PoC.exception.RegraNegocioException;
import com.gsw.PoC.model.entity.Lancamento;
import com.gsw.PoC.service.validator.LancamentoValidator;

public class ValorValidator implements LancamentoValidator{

	@Override
	public void validar(Lancamento lancamento) {
		if (lancamento.getValor() == null || lancamento.getValor().compareTo(BigDecimal.ZERO) < 1) {
			throw new RegraNegocioException("informe um valor valido");

		}		
	}

}
