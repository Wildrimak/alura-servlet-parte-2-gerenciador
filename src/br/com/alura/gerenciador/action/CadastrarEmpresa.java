package br.com.alura.gerenciador.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.dao.Banco;
import br.com.alura.gerenciador.model.Empresa;

public class CadastrarEmpresa implements Acionavel {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		Empresa empresa = new Empresa();
		empresa.setNome(nome);
		Banco banco = new Banco();
		banco.adiciona(empresa);
		
		return "redirect:ListarEmpresas";
	}

}
