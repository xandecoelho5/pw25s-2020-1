package br.edu.utfpr.pb.pw25s.library.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Livro implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 100, nullable = false)
	private String titulo;

  @ManyToOne
	@JoinColumn(name = "editora_id", referencedColumnName = "id")
	private Editora editora;

  @ManyToOne
	@JoinColumn(name = "genero_id", referencedColumnName = "id")
	private Genero genero;

  @ManyToOne
	@JoinColumn(name = "autor_id", referencedColumnName = "id")
	private Autor autor;

  @Column(nullable = false)
	private Integer ano;

  @Column(length = 20, nullable = false)
	private String isbn;

  @ManyToOne
	@JoinColumn(name = "cidade_id", referencedColumnName = "id")
	private Cidade cidade;

  @Column(nullable = false)
	private Double valor;
}