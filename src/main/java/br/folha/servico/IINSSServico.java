package br.folha.servico;

import br.servico.model.MemoriaCalculoItem;

public interface IINSSServico {
	double calcularDesconto(double salarioBruto, int dependentes);
	
	MemoriaCalculoItem calcularDescontoV2(double salarioBruto);
	MemoriaCalculoItem calcularDescontoV3(double salarioBruto);
}
