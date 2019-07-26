package br.com.vetta.avaliacao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vetta.avaliacao.modelo.Tool;

public interface ToolRepository extends JpaRepository<Tool, Long> {

	List<Tool> findByTitle(String title);
	
	List<Tool> findByTagsNameOrTitle(String tag, String titulo);
		

}
