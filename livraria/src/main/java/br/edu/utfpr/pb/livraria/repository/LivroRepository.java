package br.edu.utfpr.pb.livraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.pb.livraria.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{

}
