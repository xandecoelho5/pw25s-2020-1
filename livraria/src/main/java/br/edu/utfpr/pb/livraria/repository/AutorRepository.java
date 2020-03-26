package br.edu.utfpr.pb.livraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.pb.livraria.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long>{

}
