package br.servico.model;

public final class FaixaIRRFModel extends FaixaBase {

	public FaixaIRRFModel(double inicioFaixa,
			  double fimFaixa,
			  float   aliquota, 
			  double parcelaDeducao)		{
		super(inicioFaixa, fimFaixa, aliquota);
		this.setParcelaDeducao(parcelaDeducao);
		}	
	
	private double parcelaDeducao;

	public double getParcelaDeducao() {
		return parcelaDeducao;
	}

	public void setParcelaDeducao(double parcelaDeducao) {
		this.parcelaDeducao = parcelaDeducao;
	}

	@Override
	public double obterValorDesconto(double valor) {
		return valor * getAliquota() - getParcelaDeducao();
	}
}
