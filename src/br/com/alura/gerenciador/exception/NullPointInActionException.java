package br.com.alura.gerenciador.exception;

public class NullPointInActionException  extends NullPointerException{

	private static final long serialVersionUID = 1L;
	
	@Override
	public String getLocalizedMessage() {
		return "ESTA AÇÃO ESTA COM UMA REFERENCIA NULA, TENTE RECUPERAR UMA ACAO";
	}

}
