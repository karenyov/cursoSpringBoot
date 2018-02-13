package br.com.treinaweb.springboot.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.treinaweb.springboot.entidades.Instituicao;

/**
 * @author Karen 13 de fev de 2018
 */
public interface RepositorioInstituicao extends JpaRepository<Instituicao, Long> {
	
}
