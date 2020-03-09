package com.gsw.PoC.service.validator.implemetation;

import org.springframework.stereotype.Service;

import com.gsw.PoC.exception.RegraNegocioException;
import com.gsw.PoC.model.entity.Lancamento;
import com.gsw.PoC.service.validator.LancamentoValidator;

@Service
public class TipoValidator implements LancamentoValidator{

	@Override
	public void validar(Lancamento lancamento) {
		
		if (lancamento.getTipoLancamento() == null){
			throw new RegraNegocioException("informe um tipo valido");

		}
		
	}

}
