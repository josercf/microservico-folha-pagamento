package br.servico.model;

public class MemoriaCalculoItem {
	private String nome;
	private float aliquota;
	private double valor;
	

	public MemoriaCalculoItem(String nome, float aliquota) {
		this(nome, aliquota, 0);
	}
	
	public MemoriaCalculoItem(String nome, float aliquota, double valor) {
		super();
		this.nome = nome;
		this.aliquota = aliquota;
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getAliquota() {
		return aliquota;
	}

	public void setAliquota(float aliquota) {
		this.aliquota = aliquota;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
}
