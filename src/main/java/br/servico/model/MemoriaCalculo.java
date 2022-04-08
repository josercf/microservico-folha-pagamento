package br.servico.model;

import java.util.ArrayList;

public class MemoriaCalculo {
	private double salarioLiquido;
	
	public MemoriaCalculo(double salarioLiquido) {
		this.salarioLiquido = salarioLiquido;
		this.items = new ArrayList<MemoriaCalculoItem>();
	}
	
	private ArrayList<MemoriaCalculoItem> items;

	public double getSalarioLiquido() {
		return salarioLiquido;
	}

	public void setSalarioLiquido(double salarioLiquido) {
		this.salarioLiquido = salarioLiquido;
	}

	public ArrayList<MemoriaCalculoItem> getItems() {
		return items;
	}

	public void setItem(MemoriaCalculoItem item) {
		this.items.add(item);
	}
}
