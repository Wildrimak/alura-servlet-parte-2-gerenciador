package br.com.alura.gerenciador.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.dao.Banco;

public class RemoverEmpresa implements Acionavel {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String idString = request.getParameter("id");
		int id = Integer.parseInt(idString);
		
		Banco.removeEmpresaPorID(id);

		return "redirect:ListarEmpresas";
	}
}
