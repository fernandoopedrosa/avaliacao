package br.com.vetta.avaliacao.service.rest;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.vetta.avaliacao.dto.TagDto;
import br.com.vetta.avaliacao.dto.TagForm;
import br.com.vetta.avaliacao.modelo.Tag;
import br.com.vetta.avaliacao.repository.TagRepository;


@RestController
@RequestMapping("/rest/tags")
public class TagWebServiceRest {
	
	
	@Autowired
	private TagRepository tagRepository;
	
	@GetMapping
	public List<TagDto> listaTags(String nomeTag){
		if(nomeTag == null) {
			return TagDto.conveter(tagRepository.findAll());
		}else {
			return TagDto.conveter(tagRepository.findByName(nomeTag));
		}
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<TagDto> cadastrar(@RequestBody @Valid TagForm tagForm, UriComponentsBuilder builder) {
		Tag tag = tagForm.converter();		
		tagRepository.save(tag);		
		URI uri = builder.path("/tags/{id}").buildAndExpand(tag.getId()).toUri();		
		return ResponseEntity.created(uri).body(new TagDto(tag));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TagDto> detalhar(@PathVariable Long id) {
		Optional<Tag> tag = tagRepository.findById(id);
		if(tag.isPresent()) {
			return ResponseEntity.ok(new TagDto(tag.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?>remover(@PathVariable Long id){
		Optional<Tag> tag = tagRepository.findById(id);
		if(tag.isPresent()) {
			tagRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
		
	}

}
