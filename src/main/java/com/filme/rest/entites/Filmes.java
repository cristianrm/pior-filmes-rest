package com.filme.rest.entites;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Filmes implements Serializable, Comparable<Filmes> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String ano;
	private String titulo;
	private String studio;
	private String producer;
	private String winner;
	
	public Filmes() {
		
	}
	
	public Filmes(Long id, String ano, String titulo, String studio, String producer, String winner ) {
		super();
		this.id = id;
		this.ano = ano;
		this.titulo = titulo;
		this.studio = studio;
		this.producer = producer;
		this.winner = winner;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getStudio() {
		return studio;
	}

	public void setStudio(String studio) {
		this.studio = studio;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Filmes other = (Filmes) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public int compareTo(Filmes f) {
		
		  if (Integer.parseInt(this.ano) < Integer.parseInt(f.getAno())) {
	            return -1;
	        }
	        if (Integer.parseInt(this.ano) > Integer.parseInt(f.getAno())) {
	            return 1;
	        }
	        return 0;
	}
	
}
