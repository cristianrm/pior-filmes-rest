package com.filme.rest.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filme.rest.entites.Filmes;
import com.filme.rest.entites.FilmesFormatado;
import com.filme.rest.repository.FilmesFormatadoRepository;
import com.filme.rest.repository.FilmesRepository;

@Service
public class FilmeFormatadoService {

	@Autowired
	private FilmesFormatadoRepository filmesFormatadoRepository;

	@Autowired
	private FilmesRepository filmesRepository;

	public List<FilmesFormatado> buscarFilmesFormatado() {
		return filmesFormatadoRepository.findAll();
	}

	public List<FilmesFormatado> buscaFilmes() {

		List<Filmes> list = filmesRepository.findByWinnerConstains("winner");

		List<FilmesFormatado> liFilmesFormatados = new ArrayList<>();

		FilmesFormatado filmes;

		for (Filmes f : list) {

			String[] produtoresSplit = f.getProducer().replace(" and ", ",").split(",");

			for (int i = 0; i < produtoresSplit.length; i++) {
				String prod = produtoresSplit[i];

				filmes = new FilmesFormatado();
				filmes.setProdutor(prod);
				filmes.setAno(Integer.parseInt(f.getAno()));
				liFilmesFormatados.add(filmes);
			}
		}
		List<FilmesFormatado> listFm = new ArrayList<>();
		
		
		Collections.sort(liFilmesFormatados, new Comparator<FilmesFormatado>() {
			
			FilmesFormatado fm;
			@Override
			public int compare(FilmesFormatado f1, FilmesFormatado f2) {
				
				if (f1.getProdutor().equals(f2.getProdutor())){
					
					fm = new FilmesFormatado();
					int calcAno = f1.getAno() - f2.getAno();
					fm.setIntervalo(calcAno);
					fm.setProdutor(f1.getProdutor());
					fm.setAno(f1.getAno());
					
					listFm.add(fm);
					
				}
				
				 return f1.getProdutor().compareTo(f2.getProdutor());
			}
		});
			return listFm;
		

	}

}
