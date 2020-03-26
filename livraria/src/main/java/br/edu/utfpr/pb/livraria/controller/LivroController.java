package br.edu.utfpr.pb.livraria.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.utfpr.pb.livraria.model.Livro;
import br.edu.utfpr.pb.livraria.service.LivroService;
import br.edu.utfpr.pb.livraria.service.AutorService;
import br.edu.utfpr.pb.livraria.service.CidadeService;
import br.edu.utfpr.pb.livraria.service.EditoraService;
import br.edu.utfpr.pb.livraria.service.GeneroService;

@Controller
@RequestMapping("livro")
public class LivroController {
	
	@Autowired
  private LivroService livroService;
  @Autowired
  private AutorService autorService;
  @Autowired
  private CidadeService cidadeService;
  @Autowired
  private EditoraService editoraService;
  @Autowired
  private GeneroService generoService;
	
	@GetMapping
	public String list(Model model) {
		model.addAttribute("livros", livroService.findAll());
		return "livro/list";
	}
	
	@GetMapping(value = {"new", "novo"})
	public String form(Model model) {
    model.addAttribute("livro", new Livro());
    carregarCombos(model);
		return "livro/form";
  }
  
  private void carregarCombos(Model model) {
		model.addAttribute("autores",  autorService.findAll());
    model.addAttribute("cidades",  cidadeService.findAll());
    model.addAttribute("editoras", editoraService.findAll());
    model.addAttribute("generos",  generoService.findAll());
	}

	@PostMapping
	public String save(@Valid Livro livro, 
					   BindingResult result,
					   Model model,
					   RedirectAttributes attributes) {
		if ( result.hasErrors() ) {
      model.addAttribute("livro", livro);
      carregarCombos(model);
			return "livro/form";
		}
		
		livroService.save(livro);
		attributes.addFlashAttribute("sucesso", "Registro salvo com sucesso!");
		return "redirect:/livro";
	}

	@GetMapping("{id}")
 	public String form(@PathVariable Long id, Model model) {
    model.addAttribute("livro", livroService.findOne(id));
    carregarCombos(model);
		return "livro/form";
	}
	
	@DeleteMapping("{id}") 
	public String delete(@PathVariable Long id,
						 RedirectAttributes attributes) {
		try {
			livroService.delete(id);
			attributes.addFlashAttribute("sucesso", "Registro removido com sucesso!"); 
		} catch (Exception e) {
			attributes.addFlashAttribute("erro", "Falha ao remover o registro!");
		}
		return "redirect:/livro";
	}
}






