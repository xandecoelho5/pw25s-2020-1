package br.edu.utfpr.pb.pw25s.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.pb.pw25s.library.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{
	
	//Select * from Livro where Autor.nome like '%xd%' order by ano;
  List<Livro> findByAutorNomeContainsOrderByAno(String nome);

  //Select * from Livro where ano = ?;
  List<Livro> findByAno(Integer ano);

  //Select * from Livro where Genero.descricao = ? order by ano;
  List<Livro> findByGeneroDescricaoOrderByAno(String descricao);

  //Select * from Livro where isbn = ? or titulo = ? order by ano;
  List<Livro> findByIsbnOrTituloOrderByAno(String isbn, String titulo);

  //select * from livro where valor > ?
  List<Livro> findByValorGreaterThan(Double valor);

  //select * from livro where valor between ? and ? order by ano
  List<Livro> findByValorBetweenOrderByAno(Double valor1, Double valor2);
  
}