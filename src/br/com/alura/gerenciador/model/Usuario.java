package br.com.alura.gerenciador.model;

public class Usuario {

	private String login;
	private String senha;

	public Usuario() {
	}

	public Usuario(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean autentica(String login, String senha) {
		System.out.println("EM AUTENTICA: " + login + " " + senha);
		System.out.println("MEU LOGIN E SENHA: " +this.login + " " + this.senha);
		
		System.out.println("");
		
		if (login != this.login) {
			System.out.println("Eu Entrei aqui no login errado");
			return false;
		}
		if (senha != this.senha) {
			System.out.println("Entrei aqui na senha errada");
			return false;
		}
		return true;
	}

}
