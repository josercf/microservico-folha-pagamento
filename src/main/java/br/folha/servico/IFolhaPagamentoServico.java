package br.folha.servico;

import br.servico.model.MemoriaCalculo;

public interface IFolhaPagamentoServico {
	
	//calcular INSS
	//calcula IRRF
	//calcula salario liquido
	
	MemoriaCalculo calcularFolhaPagamento(double salarioBruto, int dependentes);
}
