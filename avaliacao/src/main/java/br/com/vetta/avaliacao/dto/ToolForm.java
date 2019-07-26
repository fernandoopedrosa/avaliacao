package br.com.vetta.avaliacao.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.vetta.avaliacao.modelo.Tag;
import br.com.vetta.avaliacao.modelo.Tool;
import br.com.vetta.avaliacao.repository.TagRepository;

public class ToolForm {
	
	@NotNull @NotEmpty
	private String title;
	@NotNull @NotEmpty
	private String link;
	@NotNull @NotEmpty
	private String description;
	
	private List<TagDto> tagsDto = new ArrayList<TagDto>();
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}	
	
	public Tool converter(TagRepository tagRespository) {
		Tool tool = new Tool(this);
		if(!this.tagsDto.isEmpty()){
			for(TagDto tagDto: this.tagsDto){
				List<Tag> lista = tagRespository.findByName(tagDto.getName());
				if(!lista.isEmpty()){
					tool.adicionaTag(lista.get(0));
				}
			}
		}
		return tool;
	}
	public List<TagDto> getTagsDto() {
		return tagsDto;
	}
	public void setTagsDto(List<TagDto> tagsDto) {
		this.tagsDto = tagsDto;
	}

}
