package br.com.vetta.avaliacao.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.vetta.avaliacao.modelo.Tool;

public class ToolDto {
	
	private Long id;	
	private String title;
	private String link;
	private String description;
	private String tagId;
	private List<TagDto> tagsDto = new ArrayList<TagDto>();
	
	public ToolDto(){}
	
	public ToolDto(Tool tool) {		
		this.id = tool.getId();
		this.title = tool.getTitle();
		this.link = tool.getLink();
		this.description = tool.getDescription();
		this.tagsDto = tool.convertTagsDtos();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
	
	
	public static List<ToolDto> conveter(List<Tool> tools) {
		List<ToolDto> dtos = new ArrayList<ToolDto>();
		
		for(Tool tool : tools) {
			dtos.add(new ToolDto(tool));
		}
		
		return dtos;
	}
	
	/*public static Tool conveter(ToolDto tool) {
		
		
		Tool tool = new 
		
		return dtos;
	}
*/
	public List<TagDto> getTagsDto() {
		return tagsDto;
	}

	public void setTagsDto(List<TagDto> tagsDto) {
		this.tagsDto = tagsDto;
	}

	public String getTagId() {
		return tagId;
	}

	public void setTagId(String tagId) {
		this.tagId = tagId;
	}

	
	
	

}
