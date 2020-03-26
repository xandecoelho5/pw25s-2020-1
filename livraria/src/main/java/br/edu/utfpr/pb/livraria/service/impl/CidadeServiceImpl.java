package br.edu.utfpr.pb.livraria.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.edu.utfpr.pb.livraria.model.Cidade;
import br.edu.utfpr.pb.livraria.repository.CidadeRepository;
import br.edu.utfpr.pb.livraria.service.CidadeService;

@Service
public class CidadeServiceImpl extends CrudServiceImpl<Cidade, Long> implements CidadeService{

	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Override
	protected JpaRepository<Cidade, Long> getRepository() {
		return cidadeRepository;
	}

}
