package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;


@WebServlet(urlPatterns = "/busca")
public class BuscaEmpresa extends HttpServlet {
	
	public BuscaEmpresa() {
		System.out.println("Contruindo um servelet do tipo BuscaEmpresa " + this);
	}
	
	
	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("Inicializando a servelet " + this);
	}
	
	@Override
	public void destroy() {
		super.destroy();
		System.out.println("Destruindo a servelet " + this);
	}
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String filtro= req.getParameter("filtro");
		
		EmpresaDAO empresaDAO = new EmpresaDAO(); 
		Collection<Empresa> empresas = empresaDAO.buscaPorSimilaridade(filtro);
		req.setAttribute("empresas", empresas);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/paginas/buscaEmpresa.jsp");
		dispatcher.forward(req, resp);
	}
	
}
