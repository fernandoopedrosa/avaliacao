package br.com.vetta.avaliacao.controller;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.vetta.avaliacao.modelo.Tool;
import br.com.vetta.avaliacao.repository.TagRepository;
import br.com.vetta.avaliacao.repository.ToolRepository;

@RestController
@RequestMapping("/tools")
public class ToolsController {
	
	@Autowired
	private ToolRepository toolRepository;
	
	@Autowired
	private TagRepository tagRespository;	
	
	
	@GetMapping
	public ModelAndView listar() {
		List<Tool> listTool = toolRepository.findAll();
		ModelAndView modelAndView = new ModelAndView("listTool");
		modelAndView.addObject("tools", listTool);
		return modelAndView;
	}
	
	@RequestMapping("/form")
	public ModelAndView form(Tool tool) {
		ModelAndView modelAndView = new ModelAndView("formTool");
		modelAndView.addObject("tags", tagRespository.findAll());
		return modelAndView;
	}
	
	@PostMapping
	@Transactional
	public ModelAndView salvar(@Valid Tool tool, BindingResult result, RedirectAttributes redirectAttributes) {		
		
		if(result.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("formTool");
			modelAndView.addObject("tags", tagRespository.findAll());
			modelAndView.addObject("tool", tool);
			
			List<String> mensagens = new ArrayList<String>();
			for(ObjectError erro: result.getAllErrors()){
				mensagens.add(erro.getDefaultMessage());
			}
			
			modelAndView.addObject("erros", mensagens);
			return modelAndView;
		}		
		
		tool.preencherCascadeTags(tagRespository);
		
		toolRepository.save(tool);
		
		redirectAttributes.addFlashAttribute("sucesso", "Cadastrado com sucesso !");
				
		return  new ModelAndView("redirect:/tools");
	}

}
