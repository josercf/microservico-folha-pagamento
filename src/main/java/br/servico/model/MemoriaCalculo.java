package br.servico.model;

import java.util.ArrayList;

public class MemoriaCalculo {
	private double salarioLiquido;
	
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

	public void setItems(ArrayList<MemoriaCalculoItem> items) {
		this.items = items;
	}
}
