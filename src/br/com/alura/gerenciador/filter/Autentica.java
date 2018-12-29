package br.com.alura.gerenciador.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/entrada")
public class Autentica implements Filter {

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession sessao = request.getSession();

        boolean ehUmaAcaoProtegida = ehUmaPaginaProtegida(request, response);
        boolean usuarioNaoEstaLogado = (sessao.getAttribute("usuarioLogado") == null);

        if(ehUmaAcaoProtegida & usuarioNaoEstaLogado) {
        	String acao = request.getParameter("acao");
        	System.out.println("acaoQueVocePodeFazerDepoisQueLogar " + acao);
            response.sendRedirect("entrada?acao=LoginForm");
            return;
        }

        chain.doFilter(request, response);
		
	}

	private boolean ehUmaPaginaProtegida(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("TESTANDO ACAO: " + request.getParameter("acao"));
		
		boolean login;
		boolean loginForm;
		
		try {
			login = request.getParameter("acao").equals("Login");
			loginForm = request.getParameter("acao").equals("LoginForm");
		} catch (Exception e) {
			return false;
		}
		
		boolean ehUmaPaginaProtegida = !(login || loginForm);
		return ehUmaPaginaProtegida;
	}
	
}
