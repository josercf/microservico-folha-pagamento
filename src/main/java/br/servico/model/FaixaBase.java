package br.servico.model;

public abstract class FaixaBase {

	private double inicioFaixa;
	private double fimFaixa;
	private double aliquota;
	
	public FaixaBase(double inicioFaixa,
			  double fimFaixa,
			  double   aliquota)		{
		this.setInicioFaixa(inicioFaixa);
		this.setFimFaixa(fimFaixa);
		this.setAliquota(aliquota);
		}	
	
	
	abstract double obterValorDesconto(double valor);
	
	public double getFimFaixa() {
		return fimFaixa;
	}
	private void setFimFaixa(double fimFaixa) {
		this.fimFaixa = fimFaixa;
	}
	public double getInicioFaixa() {
		return inicioFaixa;
	}
	public void setInicioFaixa(double inicioFaixa) {
		this.inicioFaixa = inicioFaixa;
	}
	public double getAliquota() {
		return aliquota;
	}
	private void setAliquota(double aliquota) {
		this.aliquota = aliquota;
	}
	
	public boolean contemValor(double valor)
	{		
		return valor > this.getInicioFaixa() && 
			   valor <= this.getFimFaixa();
	}
}
