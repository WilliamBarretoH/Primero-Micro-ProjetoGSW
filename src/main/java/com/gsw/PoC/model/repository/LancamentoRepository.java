package com.gsw.PoC.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gsw.PoC.model.entity.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{

	
}
