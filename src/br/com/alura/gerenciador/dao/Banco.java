package br.com.alura.gerenciador.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.gerenciador.model.Empresa;
import br.com.alura.gerenciador.model.Usuario;

public class Banco {

	private static List<Empresa> empresas = new ArrayList<>();
	private static List<Usuario> usuarios = new ArrayList<>();
	private static Integer id = 1;

	static {
		Empresa empresa1 = new Empresa();
		Empresa empresa2 = new Empresa();
		empresa1.setNome("Alura");
		empresa2.setNome("Caelum");
		empresa1.setId(id++);
		empresa2.setId(id++);
		empresas.add(empresa1);
		empresas.add(empresa2);
		Usuario user1 = new Usuario("Wildrimak", "12345");
		Usuario user2 = new Usuario("Vanusa", "54321");
		usuarios.add(user1);
		usuarios.add(user2);
	}

	public void adiciona(Empresa empresa) {
		empresa.setId(id++);
		Banco.empresas.add(empresa);
	}

	public static List<Empresa> getEmpresas() {
		return Banco.empresas;
	}

	public static Empresa getEmpresaByID(Integer id) {

		Empresa empresaSendoRetornada = null;

		for (Empresa empresa : empresas) {
			if (empresa.getId() == id) {
				empresaSendoRetornada = empresa;
			}
		}

		return empresaSendoRetornada;
	}

	public static List<Usuario> getUsuarios() {
		return Banco.usuarios;
	}

	public static Usuario existeUsuario(String login, String senha) {
		Usuario usuarioSendoRetornado = null;

		for (Usuario usuario : usuarios) {
			if (usuario.autentica(login, senha)) {
				usuarioSendoRetornado = usuario;
				return usuarioSendoRetornado;
			}
		}

		return usuarioSendoRetornado;
	}
}
