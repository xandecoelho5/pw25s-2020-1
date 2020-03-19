package br.edu.utfpr.pb.pw25s.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.pb.pw25s.library.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long>{
}