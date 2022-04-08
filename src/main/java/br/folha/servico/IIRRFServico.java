package br.folha.servico;

import br.servico.model.MemoriaCalculoItem;

public interface IIRRFServico {
	
	//Regra de calculo:
	//Identificar a faixa e aplicar o calculo abaixo
	//(salarioBase * aliquota) - parcelaADeduzir;
	MemoriaCalculoItem calcularDesconto(double salarioBase);

}
