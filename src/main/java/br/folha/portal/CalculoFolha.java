package br.folha.portal;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.folha.servico.FolhaPagamentoServico;
import br.folha.servico.IINSSServico;
import br.folha.servico.IIRRFServico;
import br.folha.servico.INSSServico;
import br.folha.servico.IRRFServico;
import br.servico.model.MemoriaCalculo;

/**
 * Servlet implementation class CalculoFolha
 */
@WebServlet("/CalculoFolha")
public class CalculoFolha extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CalculoFolha() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		double salarioBruto = request.getAttribute("salarioBruto");
		int qtdeDependentes = request.getAttribute("qtdeDependentes");
		
		IINSSServico inssServico = new INSSServico();
		IIRRFServico irrpfServico = new IRRFServico();
		
		FolhaPagamentoServico folhaServico = new FolhaPagamentoServico(inssServico, irrpfServico);
		
		MemoriaCalculo memoria = folhaServico.calcularFolhaPagamento(salarioBruto, qtdeDependentes);
		
		
		doGet(request, response);
	}

}
