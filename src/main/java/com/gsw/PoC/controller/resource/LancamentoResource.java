package com.gsw.PoC.controller.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gsw.PoC.controller.builder.LancamentoBuilder;
import com.gsw.PoC.controller.dto.ConverterLancamento;
import com.gsw.PoC.controller.dto.LancamentoDTO;
import com.gsw.PoC.exception.RegraNegocioException;
import com.gsw.PoC.model.entity.Lancamento;
import com.gsw.PoC.service.LancamentoService;
import com.gsw.PoC.service.validator.LancamentoValidator;

@RestController
@RequestMapping("/lancamento")
public class LancamentoResource {

	@Autowired
	private LancamentoService lancamentoService;
	
	@Autowired
	private ConverterLancamento converterLancamento;
	
	@Autowired
	private LancamentoValidator LancamentoValidator;
	
	@Autowired
	private LancamentoBuilder lancamentoBuilder;
	
	@PostMapping("/salvar")
	public ResponseEntity salvar(@RequestBody LancamentoDTO lancamentoDTO) {
		
		Lancamento lancamento = converterLancamento.converter(lancamentoDTO);
		
		
		try {
			
			LancamentoValidator.validar(lancamento);
			lancamentoService.salvar(lancamento);
			return new ResponseEntity(lancamento, HttpStatus.CREATED);
		} catch (RegraNegocioException e) {
			return ResponseEntity.badRequest().body(e.getMessage());

		}
	}
}
