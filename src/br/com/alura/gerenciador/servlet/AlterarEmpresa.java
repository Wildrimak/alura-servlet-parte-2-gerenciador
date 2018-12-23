package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.dao.Banco;
import br.com.alura.gerenciador.model.Empresa;

@WebServlet("/alterarEmpresa")
public class AlterarEmpresa extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String path = "empresa/alterarEmpresa.jsp";
		RequestDispatcher rd = req.getRequestDispatcher(path);
		
		String idTemp = req.getParameter("id");
		System.out.println(idTemp);
		Integer paramId = Integer.valueOf(idTemp);
		Empresa empresa = Banco.getEmpresaByID(paramId);

		req.setAttribute("id", paramId);
		req.setAttribute("nome", empresa.getNome());
		req.setAttribute("dataAbertura", empresa.getDataAbertura());

		rd.forward(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String paramRequestID = request.getParameter("id");
		int id = Integer.parseInt(paramRequestID);
		Empresa empresa = Banco.getEmpresaByID(id);

		String paramRequestNome = request.getParameter("nome");
		String paramRequestData = request.getParameter("data");

		Date dataAbertura = null;

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(paramRequestData);
		} catch (ParseException e) {
			throw new ServletException(e);
		}

		empresa.setNome(paramRequestNome);
		empresa.setDataAbertura(dataAbertura);

		response.sendRedirect("listarEmpresas");

	}

}
