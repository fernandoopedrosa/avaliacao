package br.com.vetta.avaliacao.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.vetta.avaliacao.modelo.Tag;

public class TagDto {
	
	private Long id;
	private String name;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}	
	
	public TagDto(){}
	
	public TagDto(TagDto tag) {
		this.id = tag.getId();
		this.name = tag.getName();
	}
	
	public TagDto(Tag tag) {
		this.id = tag.getId();
		this.name = tag.getName();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static List<TagDto> conveter(List<Tag> tags) {
		List<TagDto> dtos = new ArrayList<TagDto>();
		
		for(Tag tag : tags) {
			dtos.add(new TagDto(tag));
		}
		
		return dtos;
	}


	

}
