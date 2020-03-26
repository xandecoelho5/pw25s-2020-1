package br.edu.utfpr.pb.livraria.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.edu.utfpr.pb.livraria.model.Editora;
import br.edu.utfpr.pb.livraria.repository.EditoraRepository;
import br.edu.utfpr.pb.livraria.service.EditoraService;

@Service
public class EditoraServiceImpl extends CrudServiceImpl<Editora, Long> implements EditoraService{

	@Autowired
	private EditoraRepository editoraRepository;
	
	@Override
	protected JpaRepository<Editora, Long> getRepository() {
		return editoraRepository;
	}

}
