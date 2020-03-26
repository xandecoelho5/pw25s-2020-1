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

import br.edu.utfpr.pb.livraria.model.Editora;
import br.edu.utfpr.pb.livraria.service.EditoraService;

@Controller
@RequestMapping("editora")
public class EditoraController {
	
	@Autowired
	private EditoraService editoraService;
	
	@GetMapping
	public String list(Model model) {
		model.addAttribute("editoras", editoraService.findAll());
		return "editora/list";
	}
	
	@GetMapping(value = {"new", "novo", "form"})
	public String form(Model model) {
		model.addAttribute("editora", new Editora());
		return "editora/form";
	}

	@PostMapping
	public String save(@Valid Editora editora, 
					   BindingResult result,
					   Model model,
					   RedirectAttributes attributes) {
		if ( result.hasErrors() ) {
			model.addAttribute("editora", editora);
			return "editora/form";
		}
		
		editoraService.save(editora);
		attributes.addFlashAttribute("sucesso", "Registro salvo com sucesso!");
		return "redirect:/editora";
	}

	@GetMapping("{id}")
 	public String form(@PathVariable Long id, Model model) {
		model.addAttribute("editora", editoraService.findOne(id));
		return "editora/form";
	}
	
	@DeleteMapping("{id}") 
	public String delete(@PathVariable Long id,
						 RedirectAttributes attributes) {
		try {
			editoraService.delete(id);
			attributes.addFlashAttribute("sucesso", "Registro removido com sucesso!"); 
		} catch (Exception e) {
			attributes.addFlashAttribute("erro", "Falha ao remover o registro!");
		}
		return "redirect:/editora";
	}
}






