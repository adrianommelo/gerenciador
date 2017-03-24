package br.com.alura.gerenciador.web;

import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

@WebServlet(urlPatterns = "/busca")
public class BuscaEmpresa implements Tarefa {

	public BuscaEmpresa() {
		System.out.println("Contruindo um servelet do tipo BuscaEmpresa "
				+ this);
	}

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		String filtro = request.getParameter("filtro");

		EmpresaDAO empresaDAO = new EmpresaDAO();
		Collection<Empresa> empresas = empresaDAO.buscaPorSimilaridade(filtro);
		request.setAttribute("empresas", empresas);

		return "/WEB-INF/paginas/buscaEmpresa.jsp";
		
	}


}
