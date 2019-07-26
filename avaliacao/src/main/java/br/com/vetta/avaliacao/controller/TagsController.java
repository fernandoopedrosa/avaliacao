package br.com.vetta.avaliacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.vetta.avaliacao.modelo.Tag;
import br.com.vetta.avaliacao.repository.ToolRepository;

@RestController
@RequestMapping("/tags")
public class TagsController {
	
	@Autowired
	private ToolRepository toolRepository;
	
	@PostMapping
	public ModelAndView listaTools(Tag tag){
		if(tag.getParams() != null) {
			ModelAndView modelAndView = new ModelAndView("listTool");
			modelAndView.addObject("tools", toolRepository.findByTagsNameOrTitle(tag.getParams(), tag.getParams()));
			return modelAndView;
		}
		
		return new ModelAndView("listTool");
	}

}
