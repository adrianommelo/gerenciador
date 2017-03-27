package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/executa")
public class Controller extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String tarefa = req.getParameter("tarefa");
		
		if(tarefa == null)
			throw new IllegalArgumentException("Você esqueceu de passar a tarefa a ser executada!");
		
		
		try {
			//reflection
			String nomeClasse = "br.com.alura.gerenciador.web."+tarefa;
			Class<?> tipo = Class.forName(nomeClasse);
			Tarefa instancia = (Tarefa)tipo.newInstance();
//			instancia.executa(req, resp);

			//implementa o redirecionamento baseado na tarefa solicitada
			String pagina = instancia.executa(req, resp);
			RequestDispatcher dispatcher = req.getRequestDispatcher(pagina);
			dispatcher.forward(req, resp);
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException();
		}
		
	}
}
