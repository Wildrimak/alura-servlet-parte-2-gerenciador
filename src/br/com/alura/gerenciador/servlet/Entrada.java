package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.action.Acao;
import br.com.alura.gerenciador.action.Invalida;
import exception.NullPointInActionException;

@WebServlet("/entrada")
public class Entrada extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpServletResponse response;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.request = request;
		this.response = response;

		if (tenhoPermissao()) {

			Acao acao = escolhaAcaoParaExecutar();
			decidaQualRespostaEnviar(acao);
		
		} 
	}

	private boolean tenhoPermissao() throws IOException {

		
		boolean usuarioNaoEstaLogado = usuarioNaoEstaLogado();
		boolean ehUmaPaginaProtegida = ehUmaPaginaProtegida();

		if (usuarioNaoEstaLogado && ehUmaPaginaProtegida) {
			this.response.sendRedirect("entrada?acao=LoginForm");
			return false;
		}

		return true;
	}

	private boolean usuarioNaoEstaLogado() {
		HttpSession session = request.getSession();
		boolean usuarioNaoEstaLogado = (session.getAttribute("usuarioLogado") == null);
		return usuarioNaoEstaLogado;
	}

	private boolean ehUmaPaginaProtegida() {
		boolean login = request.getParameter("acao").equals("Login");
		boolean loginForm = request.getParameter("acao").equals("LoginForm");
		boolean ehUmaPaginaProtegida = !(login || loginForm);
		return ehUmaPaginaProtegida;
	}

	private Acao escolhaAcaoParaExecutar() throws ServletException, IOException {

		String action = request.getParameter("acao");
		String nomeDaClasse = "br.com.alura.gerenciador.action." + action;
		Acao acao;

		try {
			Class<?> classe = Class.forName(nomeDaClasse);
			acao = (Acao) classe.newInstance();
			return acao;
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			request.setAttribute("acaoQueFoiConsideradaInvalida", nomeDaClasse);
			return new Invalida();
		}

	}

	private void decidaQualRespostaEnviar(Acao acao) throws ServletException, IOException {
		String executa = "redirect:entrada?action=Invalida";
		try {
			executa = acao.executa(request, response);
		} catch (NullPointInActionException e) {
			throw new NullPointInActionException();
		}

		String[] tipoEEndereco = executa.split(":");

		if (tipoEEndereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/empresa/" + tipoEEndereco[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(tipoEEndereco[1]);
		}
	}

}
