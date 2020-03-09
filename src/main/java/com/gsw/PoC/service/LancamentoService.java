package com.gsw.PoC.service;

import java.util.List;

import com.gsw.PoC.model.entity.Lancamento;

public interface LancamentoService {

	Lancamento salvar (Lancamento lancamento);
	
	Lancamento atualizar(Lancamento lancamento);
	
	void deletar(Lancamento lancamento);
	
	List<Lancamento> buscar(Lancamento lancamentoFiltro);
}
