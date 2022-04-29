package br.folha.servico;

import br.servico.model.MemoriaCalculo;
import br.servico.model.MemoriaCalculoItem;

public class FolhaPagamentoServico implements IFolhaPagamentoServico {

	private IINSSServico inssServico;
	private IIRRFServico irrfServico;
	
	final double VALOR_DEDUCAO_DEPENDENTE = 189.59; 
	
	public FolhaPagamentoServico(IINSSServico inssServico, IIRRFServico irrfServico) {
		this.inssServico = inssServico;
		this.irrfServico = irrfServico;
	}

	


	
	
	
	@Override
	public MemoriaCalculo calcularFolhaPagamento(double salarioBruto, int dependentes) {
		MemoriaCalculoItem inss = inssServico.calcularDescontoV3(salarioBruto);
		double salarioBase = salarioBruto - inss.getValor();
		
		double descontoDependentes = dependentes * VALOR_DEDUCAO_DEPENDENTE;
		
		salarioBase -= descontoDependentes;
		
		MemoriaCalculoItem irrf = irrfServico.calcularDesconto(salarioBase);
		
		
		MemoriaCalculo holerite = new MemoriaCalculo(salarioBase - irrf.getValor());
		
		holerite.setItem(inss);
		holerite.setItem(irrf);
		
		return holerite;
	}

}
