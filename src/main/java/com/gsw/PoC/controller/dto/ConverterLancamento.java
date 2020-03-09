package com.gsw.PoC.controller.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsw.PoC.exception.RegraNegocioException;
import com.gsw.PoC.model.entity.Lancamento;
import com.gsw.PoC.model.entity.Usuario;
import com.gsw.PoC.model.enums.TipoLancamento;
import com.gsw.PoC.service.UsuarioService;

@Service
public class ConverterLancamento {

	@Autowired
	private UsuarioService usuarioService;

	public Lancamento converter(LancamentoDTO dto) {
		Lancamento lancamento = new Lancamento();
		lancamento.setId(dto.getId());
		lancamento.setDescricao(dto.getDescricao());
		lancamento.setValor(dto.getValor());
		
		Usuario usuario = usuarioService
			.obterPorId(dto.getUsuario())
			.orElseThrow( () -> new RegraNegocioException("Usuário não encontrado para o Id informado.") );
		
		lancamento.setUsuario(usuario);

		if(dto.getTipoLancamento() != null) {
			lancamento.setTipoLancamento(TipoLancamento.valueOf(dto.getTipoLancamento()));
		}
		
		
		
		return lancamento;
	}
}