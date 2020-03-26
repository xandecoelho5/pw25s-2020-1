package br.edu.utfpr.pb.livraria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "genero")
@Data
@NoArgsConstructor 
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@ToString
public class Genero {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "O campo 'descrição' deve ser preenchido!")
	@Column(length = 254, nullable = false)
	private String descricao;
	
}
