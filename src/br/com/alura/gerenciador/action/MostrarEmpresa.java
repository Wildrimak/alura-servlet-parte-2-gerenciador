package br.com.alura.gerenciador.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.dao.Banco;
import br.com.alura.gerenciador.model.Empresa;

public class MostrarEmpresa implements Acionavel {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String idTemp = request.getParameter("id");
		Integer paramId = Integer.valueOf(idTemp);
		Empresa empresa = Banco.getEmpresaByID(paramId);

		request.setAttribute("nome", empresa.getNome());
		request.setAttribute("dataAbertura", empresa.getDataAbertura());
		
		return "forward:alterarEmpresa.jsp";
	}

}
