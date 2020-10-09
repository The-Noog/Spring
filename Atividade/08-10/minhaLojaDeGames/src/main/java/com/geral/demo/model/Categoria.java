package com.geral.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "LojaDeGames")
public class Categoria {
	
	@Id // cria um ID
	@GeneratedValue(strategy = GenerationType.IDENTITY)// vira chave primária.
	private long id_categoria;
	
	@NotNull
	@Size(min = 4, max = 100)
	private String tipoJogo;
	
	
	@ManyToOne
	@JsonIgnoreProperties("categoria")
	private Produto produto;
	
	private Usuario usuario;
	
	public Long getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(Long id_categoria) {
		this.id_categoria = id_categoria;
	}

	public String getTipoJogo() {
		return tipoJogo;
	}

	public void setTipoJogo(String tipoJogo) {
		this.tipoJogo = tipoJogo;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public void setId_categoria(long id_categoria) {
		this.id_categoria = id_categoria;
	}		
	
	
}
