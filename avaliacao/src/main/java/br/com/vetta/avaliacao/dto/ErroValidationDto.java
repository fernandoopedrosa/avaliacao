package br.com.vetta.avaliacao.dto;

public class ErroValidationDto {
	
	private String campo;	
	private String erro;
	
	public ErroValidationDto(String campo, String erro) {
		this.campo = campo;
		this.erro = erro;
	}

	public String getCampo() {
		return campo;
	}

	public String getErro() {
		return erro;
	}

}
