package br.edu.utfpr.pb.pw25s.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.pb.pw25s.library.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long>{
}