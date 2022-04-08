package br.servico.model;

public final class FaixaINSSModel extends FaixaBase {
	
	public final double TETO_DESCONTO = 828.38;
	
	public FaixaINSSModel(double inicioFaixa,
						  double fimFaixa,
						  float   aliquota)
	{
		super.setInicioFaixa(inicioFaixa);
		super.setFimFaixa(fimFaixa);
		super.setAliquota(aliquota);		
	}	
	
	public boolean contemValor(double valor)
	{		
		return valor > this.getInicioFaixa() && 
			   valor <= this.getFimFaixa();
	}
	
	public double obterValorDesconto(double salarioBruto) {
		
		return getAliquota() == 0 ?
			   TETO_DESCONTO :
			   salarioBruto * getAliquota();
		
	}
}
