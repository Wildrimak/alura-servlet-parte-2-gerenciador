package br.com.alura.gerenciador.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.dao.Banco;
import br.com.alura.gerenciador.model.Usuario;

public class Login implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String loginUsuario = request.getParameter("login");
		String senhaUsuario = request.getParameter("senha");

		Usuario usuarioLogandoSe = Banco.existeUsuario(loginUsuario, senhaUsuario);

		if (usuarioLogandoSe != null) {
			HttpSession sessao = request.getSession();
			sessao.setAttribute("usuarioLogado", usuarioLogandoSe);
			return "redirect:entrada?acao=ListarEmpresas";
		} else {
			return "redirect:entrada?acao=LoginForm";
		}
	}

}
