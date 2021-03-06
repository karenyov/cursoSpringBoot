package br.com.treinaweb.springboot.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.treinaweb.springboot.entidades.Aluno;
import br.com.treinaweb.springboot.entidades.Instituicao;
import br.com.treinaweb.springboot.repositorios.RepositorioAluno;
import br.com.treinaweb.springboot.repositorios.RepositorioInstituicao;

/**
 * @author Karen 13 de fev de 2018
 */
@Controller
@RequestMapping("/alunos")
public class AlunosController {

	@Autowired
	private RepositorioAluno repositorioAluno;

	@Autowired
	private RepositorioInstituicao repositorioInstituicao;

	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView resultado = new ModelAndView("aluno/index");
		resultado.addObject("alunos", repositorioAluno.findAll());
		return resultado;
	}

	@GetMapping({ "/pesquisarPorNome/{nome}", "/pesquisarPorNome" })
	public @ResponseBody List<Aluno> pesquisarPorNome(@PathVariable Optional<String> nome) {
		if (!nome.isPresent()) {
			return repositorioAluno.findAll();
		}
		return repositorioAluno.findByNomeContaining(nome.get());
	}

	@GetMapping("/inserir")
	public ModelAndView inserir() {
		ModelAndView resultado = new ModelAndView("aluno/inserir");
		Aluno aluno = new Aluno();
		aluno.setInstituicao(new Instituicao());
		resultado.addObject("aluno", new Aluno());
		resultado.addObject("instituicoes", repositorioInstituicao.findAll());
		return resultado;
	}

	@PostMapping("/inserir")
	public String inserir(Aluno aluno) {
		repositorioAluno.save(aluno);
		return "redirect:/alunos/index";
	}

	@GetMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		Aluno aluno = repositorioAluno.findOne(id);
		ModelAndView resultado = new ModelAndView("aluno/editar");
		resultado.addObject("aluno", aluno);
		resultado.addObject("instituicoes", repositorioInstituicao.findAll());
		return resultado;
	}

	@PostMapping("/editar")
	public String editar(Aluno aluno) {
		repositorioAluno.save(aluno);
		return "redirect:/alunos/index";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable Long id) {
		repositorioAluno.delete(id);
		return "redirect:/alunos/index";
	}
}
