package br.folha.servico;

import java.util.ArrayList;

import br.servico.model.FaixaINSSModel;
import br.servico.model.MemoriaCalculoItem;

public class INSSServico implements IINSSServico {

	@Override
	public double calcularDesconto(double salarioBruto, int dependentes) {
		//receber o salário bruto
		//identificar a faixa
		//aplicar aliquota de desconto
		
		if(salarioBruto > 0 && salarioBruto <= 1212)
			return salarioBruto * 0.075;
		
		//De R$ 1.212 até R$ 2.427,35	9%
		if(salarioBruto > 1212 && salarioBruto <= 2427.35)
			return salarioBruto * 0.09;

		//De 2.427,36 até R$ 3.641,03	12%
		if(salarioBruto >= 2427.36 && salarioBruto <= 3641.03)
			return salarioBruto * 0.12;
		
		//De R$ 3.641,04 até R$ 7.087,22	14%
		if(salarioBruto >= 3641.04 && salarioBruto <= 7087.22)
			return salarioBruto * 0.14;
		
		if(salarioBruto > 7087.22)
			return 828.38; 
		
		// TODO Auto-generated method stub
		return 0;
	}
	
	private ArrayList<FaixaINSSModel> carregarFaixas()
	{	
		ArrayList<FaixaINSSModel> tabela = new ArrayList<FaixaINSSModel>();
		
		FaixaINSSModel faixa01 = new FaixaINSSModel(0, 1212, (float)0.075);
		FaixaINSSModel faixa02 = new FaixaINSSModel(1212.01, 2427.35, (float)0.09);
		FaixaINSSModel faixa03 = new FaixaINSSModel(2427.36, 3641.03, (float)0.12);
		FaixaINSSModel faixa04 = new FaixaINSSModel(3641.04, 7087.22, (float)0.14);
		FaixaINSSModel faixaTeto = new FaixaINSSModel(7087.22, 1_000_000, (float)0.0);
		
		tabela.add(faixa01);
		tabela.add(faixa02);
		tabela.add(faixa03);
		tabela.add(faixa04);
		tabela.add(faixaTeto);
		
		return tabela;
	}
	
	private FaixaINSSModel EncontrarFaixaV3(double salarioBruto)
	{
		ArrayList<FaixaINSSModel> tabela = carregarFaixas();
		
		//para cada item da tabela 
		//chamarf o método contemValor
		//se for positivo, retornamos a faixa
		
		for( FaixaINSSModel linha: tabela) {
			if(linha.contemValor(salarioBruto))
				return linha;
		}
		
		return null;
	}

	
	private FaixaINSSModel EncontrarFaixaV2(double salarioBruto)
	{
		FaixaINSSModel faixa01 = new FaixaINSSModel(0, 1212, (float)0.075);
		FaixaINSSModel faixa02 = new FaixaINSSModel(1212.01, 2427.35, (float)0.09);
		FaixaINSSModel faixa03 = new FaixaINSSModel(2427.36, 3641.03, (float)0.12);
		FaixaINSSModel faixa04 = new FaixaINSSModel(3641.04, 7087.22, (float)0.14);
		FaixaINSSModel faixaTeto = new FaixaINSSModel(7087.22, 1_000_000, (float)0.0);
		
		
		if(faixa01.contemValor(salarioBruto))
			return faixa01;
		
		//De R$ 1.212 até R$ 2.427,35	9%
		if(faixa02.contemValor(salarioBruto))
			return faixa02;

		//De 2.427,36 até R$ 3.641,03	12%
		if(faixa03.contemValor(salarioBruto))
			return faixa03;
		
		//De R$ 3.641,04 até R$ 7.087,22	14%
		if(faixa04.contemValor(salarioBruto))
			return faixa04;
		
		if(faixaTeto.contemValor(salarioBruto))
			return faixaTeto; 
		
		return null;
	}
	
	private FaixaINSSModel EncontrarFaixa(double salarioBruto)
	{
		FaixaINSSModel faixa01 = new FaixaINSSModel(0, 1212, (float)0.075);
		FaixaINSSModel faixa02 = new FaixaINSSModel(1212.01, 2427.35, (float)0.09);
		FaixaINSSModel faixa03 = new FaixaINSSModel(2427.36, 3641.03, (float)0.12);
		FaixaINSSModel faixa04 = new FaixaINSSModel(3641.04, 7087.22, (float)0.14);
		FaixaINSSModel faixaTeto = new FaixaINSSModel(7087.22, 1_000_000, (float)0.0);
		
		
		if(salarioBruto > faixa01.getInicioFaixa() && 
		   salarioBruto <= faixa01.getFimFaixa())
			return faixa01;
		
		//De R$ 1.212 até R$ 2.427,35	9%
		if(salarioBruto > faixa02.getInicioFaixa() && 
		   salarioBruto <= faixa02.getFimFaixa())
					return faixa02;

		//De 2.427,36 até R$ 3.641,03	12%
		if(salarioBruto > faixa03.getInicioFaixa() && 
		   salarioBruto <= faixa03.getFimFaixa())
					return faixa03;
		
		//De R$ 3.641,04 até R$ 7.087,22	14%
		if(salarioBruto > faixa04.getInicioFaixa() && 
		   salarioBruto <= faixa04.getFimFaixa())
					return faixa04;
		
		if(salarioBruto > faixaTeto.getInicioFaixa())
			return faixaTeto; 
		
		return null;
	}

	@Override
	public MemoriaCalculoItem calcularDescontoV2(double salarioBruto) {
		
		FaixaINSSModel faixa = EncontrarFaixaV3(salarioBruto);
		
		MemoriaCalculoItem item = new MemoriaCalculoItem("INSS", faixa.getAliquota());
	
		item.setValor(faixa.obterValorDesconto(salarioBruto));
		
		return item;		
	}
	
	@Override
	public MemoriaCalculoItem calcularDescontoV3(double salarioBruto) {
		
		FaixaINSSModel faixa = EncontrarFaixaV3(salarioBruto);
		
		return 
				new MemoriaCalculoItem("INSS", 
						faixa.getAliquota(), 
						faixa.obterValorDesconto(salarioBruto));
	}

}
