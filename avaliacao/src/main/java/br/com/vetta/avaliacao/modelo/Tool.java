package br.com.vetta.avaliacao.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

import br.com.vetta.avaliacao.dto.TagDto;
import br.com.vetta.avaliacao.dto.ToolForm;
import br.com.vetta.avaliacao.repository.TagRepository;

@Entity
public class Tool {

	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="Título não pode ser em branco")
	private String title;
	@NotBlank(message="Link não pode ser em branco")
	private String link;
	@NotBlank(message="Descrição não pode ser em branco")
	private String description;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "tool_tag",
		joinColumns = { @JoinColumn(name = "fk_tool") } , 
		inverseJoinColumns = {@JoinColumn(name = "fk_tag")})
	private List<Tag> tags = new ArrayList<Tag>();
	
	@Transient
	private String tagIds;
	

	public Tool() {
		
	}
	
	public void adicionaTag(Tag tag){
		this.tags.add(tag);
	}
	
	public Tool(ToolForm form) {				
		this.title = form.getTitle();
		this.link = form.getLink();
		this.description = form.getDescription();
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

	public List<Tag> getTags() {
		return tags;
	}
	
	public String getTagIds() {
		return tagIds;
	}

	public void setTagIds(String tagIds) {
		this.tagIds = tagIds;
	}
	
	
	public List<TagDto> convertTagsDtos(){
		List<TagDto> dtos = new ArrayList<TagDto>();
		for(Tag tag : tags) {
			dtos.add(new TagDto(tag));
		}
		return dtos;
	}
	
	public void preencherCascadeTags(TagRepository tagRespository){
		if(this.tagIds != null){
			String[] obj = this.tagIds.split(",");		
			for(int i=0;i<obj.length;i++){			
				adicionaTag(tagRespository.getOne(Long.valueOf(obj[i])));
			}
		}
	}

	
			
}
