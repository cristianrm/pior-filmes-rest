package com.filme.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filme.rest.entites.Filmes;
import com.filme.rest.repository.FilmesRepository;

@Service
public class FilmeService {
	
	@Autowired
	private FilmesRepository filmesRepository;
	
	
	public List<Filmes> buscarFilmes(){
		return filmesRepository.findAll();
	}
	
	

}
