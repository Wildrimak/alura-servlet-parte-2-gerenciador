package br.com.alura.gerenciador.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.gerenciador.model.Empresa;

public class Banco {

	private static List<Empresa> lista = new ArrayList<>();
	private static Integer id = 1;
	
	static {
		Empresa empresa1 = new Empresa();
		Empresa empresa2 = new Empresa();
		empresa1.setNome("Alura");
		empresa2.setNome("Caelum");
		empresa1.setId(id++);
		empresa2.setId(id++);
		lista.add(empresa1);
		lista.add(empresa2);
	}

	public void adiciona(Empresa empresa) {
		empresa.setId(id++);
		Banco.lista.add(empresa);
	}

	public static List<Empresa> getLista() {
		return Banco.lista;
	}

	public static Empresa getEmpresaByID(Integer id) {

		Empresa empresaSendoRetornada = null;

		for (Empresa empresa : lista) {
			if (empresa.getId() == id) {
				empresaSendoRetornada = empresa;
			}
		}

		return empresaSendoRetornada;
	}
}
