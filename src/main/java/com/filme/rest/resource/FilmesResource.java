package com.filme.rest.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filme.rest.entites.Filmes;
import com.filme.rest.service.FilmeService;

@RestController
@RequestMapping("/f")
public class FilmesResource {

	@Autowired
	private FilmeService filmeService;
	
	@GetMapping
	public ResponseEntity<List<Filmes>>findAll(){
		List<Filmes> list = filmeService.buscarFilmes();
		return ResponseEntity.ok().body(list);
	}
	
	
	
}
