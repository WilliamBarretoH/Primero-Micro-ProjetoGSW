package com.gsw.PoC.service.implemetation;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsw.PoC.model.entity.Lancamento;
import com.gsw.PoC.model.repository.LancamentoRepository;
import com.gsw.PoC.service.LancamentoService;
import com.gsw.PoC.service.validator.LancamentoValidator;

@Service
public class LancamentoImplemetation implements LancamentoService{

	@Autowired
	private LancamentoValidator lancamentoValidator;
	
	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	@Override
	@Transactional
	public Lancamento salvar(Lancamento lancamento) {
		lancamentoValidator.validar(lancamento);
		return lancamentoRepository.save(lancamento);
	}

	@Override
	public Lancamento atualizar(Lancamento lancamento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletar(Lancamento lancamento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Lancamento> buscar(Lancamento lancamentoFiltro) {
		// TODO Auto-generated method stub
		return null;
	}

}
