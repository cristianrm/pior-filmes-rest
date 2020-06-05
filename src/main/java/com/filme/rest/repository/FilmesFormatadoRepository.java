package com.filme.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.filme.rest.entites.FilmesFormatado;

public interface FilmesFormatadoRepository extends JpaRepository<FilmesFormatado, Long> {

}
