package br.com.vetta.avaliacao.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vetta.avaliacao.modelo.Tag;
import br.com.vetta.avaliacao.modelo.Tool;

public interface TagRepository extends JpaRepository<Tag, Long> {

	List<Tag> findByName(String name);
	
	Set<Tool> findByToolsTitleOrName(String titulo, String tag);

}
