package br.com.vetta.avaliacao.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.vetta.avaliacao.modelo.Tag;

public class TagForm {
	
	@NotNull @NotEmpty @Length(min = 3)
	private String name;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Tag converter() {
		return new Tag(this);
	}
	
	
	

}
