package br.edu.utfpr.pb.livraria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "livro")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@ToString
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "O campo 'Título' deve ser preenchido!")
	@Column(length = 100, nullable = false)
	private String titulo;

	@NotNull(message = "O campo 'editora' deve ser preenchido!")
  @ManyToOne
	@JoinColumn(name = "editora_id", referencedColumnName = "id")
	private Editora editora;

	@NotNull(message = "O campo 'genero' deve ser preenchido!")
  @ManyToOne
	@JoinColumn(name = "genero_id", referencedColumnName = "id")
	private Genero genero;

	@NotNull(message = "O campo 'autor' deve ser preenchido!")
  @ManyToOne
	@JoinColumn(name = "autor_id", referencedColumnName = "id")
	private Autor autor;

	@NotNull(message = "O campo 'ano' deve ser preenchido!")
	@Min(value = 1500, message = "O ano não pode ser menor do que 1500")
	@Max(value = 2020, message = "O ano não pode ser maior do que 2020")
  @Column(nullable = false)
	private Integer ano;

	@NotEmpty(message = "O campo 'isbn' deve ser preenchido!")
  @Column(length = 20, nullable = false)
	private String isbn;

	@NotNull(message = "O campo 'cidade' deve ser preenchido!")
  @ManyToOne
	@JoinColumn(name = "cidade_id", referencedColumnName = "id")
	private Cidade cidade;

	@NotNull(message = "O campo 'valor' deve ser preenchido!")
	@Column(nullable = false)
	@Min(value = 0, message = "O valor deve ser maior do que 0 (zero)!")
	@Max(value = 10000, message = "O valor deve ser menor do que 10000 (dez mil)!")
	private Double valor;
}