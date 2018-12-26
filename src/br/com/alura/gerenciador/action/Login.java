package br.com.alura.gerenciador.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.dao.Banco;
import br.com.alura.gerenciador.model.Usuario;

public class Login implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String loginUsuario = request.getParameter("login");
		String senhaUsuario = request.getParameter("senha");

		Usuario usuarioLogandoSe = Banco.existeUsuario(loginUsuario, senhaUsuario);
		String conseguiu; 
		conseguiu = usuarioLogandoSe.getLogin();
		
		
		System.out.println("O usuario logou-se? " + conseguiu);
		
		
		
		
		System.out.println("Login: " + loginUsuario + " Senha: " + senhaUsuario);

		
		
		if (usuarioLogandoSe != null) {
			return "redirect:entrada?acao=ListarEmpresas";
		} else {
			return "redirect:entrada?acao=LoginForm";
		}
	}

}
