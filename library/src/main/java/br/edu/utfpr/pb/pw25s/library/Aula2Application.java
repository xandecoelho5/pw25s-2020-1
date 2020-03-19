package br.edu.utfpr.pb.pw25s.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.utfpr.pb.pw25s.library.model.Livro;
import br.edu.utfpr.pb.pw25s.library.model.Autor;
import br.edu.utfpr.pb.pw25s.library.model.Editora;
import br.edu.utfpr.pb.pw25s.library.model.Genero;
import br.edu.utfpr.pb.pw25s.library.model.Cidade;
import br.edu.utfpr.pb.pw25s.library.repository.LivroRepository;
import br.edu.utfpr.pb.pw25s.library.repository.AutorRepository;
import br.edu.utfpr.pb.pw25s.library.repository.EditoraRepository;
import br.edu.utfpr.pb.pw25s.library.repository.GeneroRepository;
import br.edu.utfpr.pb.pw25s.library.repository.CidadeRepository;

@SpringBootApplication
public class Aula2Application implements CommandLineRunner {

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private AutorRepository autorRepository;

	@Autowired
	private EditoraRepository editoraRepository;

	@Autowired
	private GeneroRepository generoRepository;

	@Autowired
	private LivroRepository livroRepository;

	public static void main(String[] args) {
		SpringApplication.run(Aula2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Cidade c1 = new Cidade();
		c1.setNome("Pato Branco");
		salvarCidade(c1);

		Cidade c2 = new Cidade();
		c2.setNome("Curitibenos");
		salvarCidade(c2);

		Autor a1 = new Autor();
		a1.setNome("Francisco Bacon");
		salvarAutor(a1);

		Autor a2 = new Autor();
		a2.setNome("Montenegro");
		salvarAutor(a2);

		Editora e1 = new Editora();
		e1.setNome("Editora Paulino");
		salvarEditora(e1);

		Editora e2 = new Editora();
		e2.setNome("Editora Samba");
		salvarEditora(e2);

		Genero g1 = new Genero();
		g1.setDescricao("Fictício");
		salvarGenero(g1);

		Genero g2 = new Genero();
		g2.setDescricao("Glória e Morte");
		salvarGenero(g2);

		Livro l1 = new Livro();
		l1.setTitulo("Os 5 caminhos da Guerra Juninho");
		l1.setEditora(e1);
		l1.setGenero(g1);
		l1.setAutor(a1);
		l1.setAno(2015);
		l1.setIsbn("Os");
		l1.setCidade(c1);
		l1.setValor(250.5);
		salvarLivro(l1);

		Livro l2 = new Livro();
		l2.setTitulo("Os sabores da vitória amarga");
		l2.setEditora(e2);
		l2.setGenero(g2);
		l2.setAutor(a2);
		l2.setAno(2020);
		l2.setIsbn("sabores");
		l2.setCidade(c2);
		l2.setValor(125.5);
		salvarLivro(l2);

		listarLivros();
		ShowAllQueries();
	}

	private void salvarCidade(Cidade cidade) {
		this.cidadeRepository.save(cidade);
		System.out.println("Cidade salva com sucesso! \n " + cidade);
	}

	private void salvarAutor(Autor autor) {
		this.autorRepository.save(autor);
		System.out.println("autor salvo com sucesso! \n " + autor);
	}

	private void salvarEditora(Editora editora) {
		this.editoraRepository.save(editora);
		System.out.println("editora salva com sucesso! \n " + editora);
	}

	private void salvarGenero(Genero genero) {
		this.generoRepository.save(genero);
		System.out.println("genero salvo com sucesso! \n " + genero);
	}

	private void salvarLivro(Livro livro) {
		this.livroRepository.save(livro);
		System.out.println("livro salvo com sucesso! \n " + livro);
	}

	private void listarLivros() {
		System.out.println("\n *********** LISTA DE LIVROS ***********");
		this.livroRepository.findAll().forEach(l -> System.out.println(l));
		System.out.println("\n *********** LISTA DE LIVROS ***********");
	}

	private void ShowAllQueries() {
		System.out.println(
				"\n *********** Retornar os Livros pesquisando por parte do nome do autor e ordenando por ano. ***********");
		this.livroRepository.findByAutorNomeContainsOrderByAno("acon").forEach(l -> System.out.println(l));

		System.out.println("\n *********** Retornar os livros filtrando por ano. ***********");
		this.livroRepository.findByAno(2015).forEach(l -> System.out.println(l));

		System.out.println(
				"\n *********** Retornar os livros filtrando pela descrição do gênero e ordenando por ano. ***********");
		this.livroRepository.findByGeneroDescricaoOrderByAno("Fictício").forEach(l -> System.out.println(l));

		System.out.println(
				"\n *********** Retornar os livros filtrando a mesma string pelo ISBN ou Título e ordenar por ano ***********");
		this.livroRepository.findByIsbnOrTituloOrderByAno("Os", "Os").forEach(l -> System.out.println(l));

		System.out.println("\n *********** Retornar os livros com valores maiores que... ***********");
		this.livroRepository.findByValorGreaterThan(100.50).forEach(l -> System.out.println(l));

		System.out.println("\n *********** Retornar os livros com valores entre A* e B* ordenados por ano ***********");
		this.livroRepository.findByValorBetweenOrderByAno(100.5, 150.0).forEach(l -> System.out.println(l));
	}
}
