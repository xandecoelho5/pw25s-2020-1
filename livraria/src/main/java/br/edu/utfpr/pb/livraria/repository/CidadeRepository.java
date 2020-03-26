package br.edu.utfpr.pb.livraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.pb.livraria.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long>{

}
