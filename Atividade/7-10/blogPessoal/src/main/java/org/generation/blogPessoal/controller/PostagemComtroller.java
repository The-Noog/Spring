package org.generation.blogPessoal.controller;

import java.util.List;

import org.generation.blogPessoal.model.Postagem;
import org.generation.blogPessoal.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/postagens") // Requisição
@CrossOrigin("*") // Aceita requisições de qualquer origem
public class PostagemComtroller {
	// Injetando o repositório
	@Autowired
	private PostagemRepository repositoty;

	// Metodo de Find All
	@GetMapping
	public ResponseEntity<List<Postagem>> GetAll() {
		return ResponseEntity.ok(repositoty.findAll());
	}

//Controller FindById	
	@GetMapping("/{id}")
	public ResponseEntity<Postagem> GetById(@PathVariable long id) {
		return repositoty.findById(id) // devolve tanto o objeto postagem quanto o objeto seja not found
				.map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

//Controller FindByITitulo
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Postagem>> GetBYTitulo(@PathVariable String titulo) {
		return ResponseEntity.ok(repositoty.findAllByTituloContainingIgnoreCase(titulo));
	}

//Controller Post Put I
	@PostMapping
	public ResponseEntity<Postagem> post(@RequestBody Postagem postagem) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repositoty.save(postagem));
	}

//Controller Post Put II
	@PutMapping
	public ResponseEntity<Postagem> put(@RequestBody Postagem postagem) {
		return ResponseEntity.status(HttpStatus.OK).body(repositoty.save(postagem));
	}
// Controller Delete
	@DeleteMapping("/{id}")
	// O comando void não retorna nada!
	public void delete(@PathVariable long id) 
	{
		repositoty.deleteById(id);
	}
}
