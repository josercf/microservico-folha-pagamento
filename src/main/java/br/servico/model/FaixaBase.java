package br.servico.model;

public abstract class FaixaBase {

	private double inicioFaixa;
	private double fimFaixa;
	private float aliquota;
	public double getFimFaixa() {
		return fimFaixa;
	}
	public void setFimFaixa(double fimFaixa) {
		this.fimFaixa = fimFaixa;
	}
	public double getInicioFaixa() {
		return inicioFaixa;
	}
	public void setInicioFaixa(double inicioFaixa) {
		this.inicioFaixa = inicioFaixa;
	}
	public float getAliquota() {
		return aliquota;
	}
	public void setAliquota(float aliquota) {
		this.aliquota = aliquota;
	}
}
