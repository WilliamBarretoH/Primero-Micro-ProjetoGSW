package com.gsw.PoC.controller.dto;

import java.math.BigDecimal;

import com.gsw.PoC.model.entity.Usuario;
import com.gsw.PoC.model.enums.TipoLancamento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LancamentoDTO {

	private Long id;
	private BigDecimal valor;
	private Long usuario;
	private String descricao;
	private String tipoLancamento;
}
