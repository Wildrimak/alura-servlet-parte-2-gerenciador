package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.action.Acionavel;
import br.com.alura.gerenciador.action.Invalida;

@WebServlet("/entrada")
public class Entrada extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Acionavel acao = escolherAcionavel(request, response);
		decidaQualRespostaEnviar(acao, request, response);

	}

	private Acionavel escolherAcionavel(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("acao");
		String nomeDaClasse = "br.com.alura.gerenciador.action." + action;
		Acionavel acao;

		try {
			Class<?> classe = Class.forName(nomeDaClasse);
			acao = (Acionavel) classe.newInstance();
			return acao;
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			request.setAttribute("acaoQueFoiConsideradaInvalida", nomeDaClasse);
			System.out.println(nomeDaClasse);
			return new Invalida();
		}

	}

	private void decidaQualRespostaEnviar(Acionavel acao, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String executa = "redirect:entrada?action=Invalida";

		executa = acao.executa(request, response);

		String[] tipoEEndereco = executa.split(":");
		
		System.out.println(executa);
		System.out.println(tipoEEndereco[1]);
		
		if (tipoEEndereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/empresa/" + tipoEEndereco[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect("entrada?action=" + tipoEEndereco[1]);
		}
	}

}
