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
import br.com.vetta.avaliacao.dto.ToolDto;
import br.com.vetta.avaliacao.dto.ToolForm;
import br.com.vetta.avaliacao.modelo.Tool;
import br.com.vetta.avaliacao.repository.TagRepository;
import br.com.vetta.avaliacao.repository.ToolRepository;


@RestController
@RequestMapping("/rest/tools")
public class ToolWebServiceRest {
	
	
	@Autowired
	private ToolRepository toolRepository;
	
	@Autowired
	private TagRepository tagRespository;
	
	
	@GetMapping
	public List<ToolDto> listaTags(String params){
		if(params == null) {
			return ToolDto.conveter(toolRepository.findAll());
		}else {
			return ToolDto.conveter(toolRepository.findByTagsNameOrTitle(params, params));
		}
	}
	
	@GetMapping("/params/{params}")
	public List<ToolDto> listar(@PathVariable String params){		
		return ToolDto.conveter(toolRepository.findByTagsNameOrTitle(params, params));		
	}
	
	
	@PostMapping
	@Transactional
	public ResponseEntity<ToolDto> cadastrar(@RequestBody @Valid ToolForm toolForm, UriComponentsBuilder builder) {		
		Tool tool = toolForm.converter(tagRespository);
		toolRepository.save(tool);		
		URI uri = builder.path("/tags/{id}").buildAndExpand(tool.getId()).toUri();		
		return ResponseEntity.created(uri).body(new ToolDto(tool));		
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<ToolDto> detalhar(@PathVariable Long id) {
		Optional<Tool> tool = toolRepository.findById(id);
		if(tool.isPresent()) {
			return ResponseEntity.ok(new ToolDto(tool.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?>remover(@PathVariable Long id){
		Optional<Tool> tool = toolRepository.findById(id);
		if(tool.isPresent()) {
			toolRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}		
		return ResponseEntity.notFound().build();		
	}

}
