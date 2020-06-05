package com.filme.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.filme.rest.entites.Filmes;

public interface FilmesRepository extends JpaRepository<Filmes, Long>{
	
	
	  @Query("select u from Filmes u where u.winner = ?1")
	  List<Filmes> findByWinnerConstains(String winner);
	 

}
