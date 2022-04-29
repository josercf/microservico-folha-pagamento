package br.servico.model;

public final class FaixaINSSModel extends FaixaBase {
	public final double TETO_DESCONTO = 828.38;
	
	public FaixaINSSModel(double inicioFaixa, double fimFaixa, double aliquota) {
		super(inicioFaixa, fimFaixa, aliquota);
	}

	@Override
	public double obterValorDesconto(double valor) {
		
		return super.getAliquota() == 0 ?
			   TETO_DESCONTO :
				   valor * super.getAliquota();
		
	}
	
	
}
