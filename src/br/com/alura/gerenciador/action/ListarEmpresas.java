package br.com.alura.gerenciador.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.dao.Banco;
import br.com.alura.gerenciador.model.Empresa;

public class ListarEmpresas implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Empresa> empresas = Banco.getLista();
		request.setAttribute("empresas", empresas);
		
		return "forward:listarEmpresas.jsp";
		
	}

}
