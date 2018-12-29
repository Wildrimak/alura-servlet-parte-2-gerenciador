package br.com.alura.gerenciador.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login implements Acionavel {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String paginaQueEuQueriaIr = "ListarEmpresas";
		return "redirect:" + paginaQueEuQueriaIr;
	}

}