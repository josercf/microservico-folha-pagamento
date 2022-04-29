package br.folha.servico;

import java.util.ArrayList;

import br.servico.model.FaixaINSSModel;
import br.servico.model.FaixaIRRFModel;
import br.servico.model.MemoriaCalculoItem;

public class IRRFServico implements IIRRFServico{

	@Override
	public MemoriaCalculoItem calcularDesconto(double salarioBase) {
		
		//Regra de calculo:
		//Identificar a faixa e aplicar o calculo abaixo
		//(salarioBase * aliquota) - parcelaADeduzir;
		
		FaixaIRRFModel faixa = EncontrarFaixa(salarioBase);
		
		return 
				new MemoriaCalculoItem("INSS", 
						faixa.getAliquota(), 
						faixa.obterValorDesconto(salarioBase));
		
	}
	
	private FaixaIRRFModel EncontrarFaixa(double salarioBase)
	{
		ArrayList<FaixaIRRFModel> tabela = carregarFaixas();
		
		//para cada item da tabela 
		//chamarf o método contemValor
		//se for positivo, retornamos a faixa
		
		for( FaixaIRRFModel linha: tabela) {
			if(linha.contemValor(salarioBase))
				return linha;
		}
		
		return null;
	}
	
	
	private ArrayList<FaixaIRRFModel> carregarFaixas()
	{	
		ArrayList<FaixaIRRFModel> tabela = new ArrayList<FaixaIRRFModel>();
		
		FaixaIRRFModel faixa01 = new FaixaIRRFModel(0,  1903.98, (float)0.0, 0);
		FaixaIRRFModel faixa02 = new FaixaIRRFModel(1903.99, 2826.655, (float)0.075, 142.80);
		FaixaIRRFModel faixa03 = new FaixaIRRFModel( 2826.66, 3751.05, (float)0.15,  354.80);
		FaixaIRRFModel faixa04 = new FaixaIRRFModel(3751.06, 4664.68, (float)0.225, 636.13);
		FaixaIRRFModel faixaTeto = new FaixaIRRFModel(4664.68, 1_000_000, (float)0.275,  869.36);
		
		tabela.add(faixa01);
		tabela.add(faixa02);
		tabela.add(faixa03);
		tabela.add(faixa04);
		tabela.add(faixaTeto);
		
		return tabela;
	}


}
