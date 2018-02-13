package br.com.treinaweb.springboot.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.treinaweb.springboot.entidades.Instituicao;

/**
 * @author Karen 13 de fev de 2018
 */
public interface RepositorioInstituicao extends JpaRepository<Instituicao, Long> {
	
	List<Instituicao> findByNomeContaining(String nome); //busca como se fosse um LIKE (containing)
}
