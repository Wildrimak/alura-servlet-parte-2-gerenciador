package br.com.alura.gerenciador.action;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.dao.Banco;
import br.com.alura.gerenciador.model.Empresa;

public class EditarEmpresa implements Acionavel {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idString = request.getParameter("id");
		int id = Integer.parseInt(idString);
		Empresa empresa = Banco.getEmpresaByID(id);

		String nome = request.getParameter("nome");
		String data = request.getParameter("data");

		Date dataAbertura = formatarDataDaRequisicao(data);
		empresa.setNome(nome);
		empresa.setDataAbertura(dataAbertura);

//		response.sendRedirect("listarEmpresas");

		return "redirect:ListarEmpresas";
	}
	
private Date formatarDataDaRequisicao(String data) throws ServletException {
		
		Date dataAbertura = null;

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(data);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		return dataAbertura;
	}

}
