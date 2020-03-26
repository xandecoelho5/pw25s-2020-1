package br.edu.utfpr.pb.livraria.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.edu.utfpr.pb.livraria.model.Autor;
import br.edu.utfpr.pb.livraria.repository.AutorRepository;
import br.edu.utfpr.pb.livraria.service.AutorService;

@Service
public class AutorServiceImpl extends CrudServiceImpl<Autor, Long> implements AutorService{

	@Autowired
	private AutorRepository autorRepository;
	
	@Override
	protected JpaRepository<Autor, Long> getRepository() {
		return autorRepository;
	}

}
