package com.filme.rest.resource;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filme.rest.entites.FilmesFormatado;
import com.filme.rest.service.FilmeFormatadoService;

@RestController
@RequestMapping("/filmes")
public class FilmeFormatadoResource {
	
	@Autowired
	private FilmeFormatadoService filmeFormadao;
	
	@GetMapping
	public ResponseEntity<List<FilmesFormatado>>findAll(){
		List<FilmesFormatado> list = filmeFormadao.buscaFilmes();
		
		List<FilmesFormatado> liFilmesFormatados;
		
		FilmesFormatado filmesMin = list.stream().min(Comparator.comparing(FilmesFormatado::getIntervalo)).orElseThrow(NoSuchElementException::new);
		FilmesFormatado filmesMax = list.stream().max(Comparator.comparing(FilmesFormatado::getIntervalo)).orElseThrow(NoSuchElementException::new);
		
		liFilmesFormatados = Arrays.asList(filmesMin,filmesMax);
		
		return ResponseEntity.ok().body(liFilmesFormatados);
	}


}
