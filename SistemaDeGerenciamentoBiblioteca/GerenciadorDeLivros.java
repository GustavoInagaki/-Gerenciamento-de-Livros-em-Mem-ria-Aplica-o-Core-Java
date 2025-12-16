package SistemaDeGerenciamentoBiblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class GerenciadorDeLivros {

	
	private final List<Livro> colecao = new ArrayList<Livro>();
	
	private final AtomicInteger idGenerator = new AtomicInteger(1);
	
	
	public Livro adicionar(String titulo, String autor, int ano) {
		
		if(titulo == null || titulo.trim().isEmpty() || autor == null || autor.trim().isEmpty()) {
			throw new IllegalArgumentException("Titulo e autor não podem ser vazio.");
		}
		
		int novoId = idGenerator.getAndIncrement();
		Livro livro = new Livro(novoId, titulo, autor, ano);
		colecao.add(livro);
		return livro;
		
	}
	
	public List<Livro> listarTodos(){
		return colecao;
	}
	
	public Optional<Livro> buscarPorId(int id){
		return colecao.stream()
				.filter(l -> l.getId() == id)
				.findFirst();
	}
	
	public Livro atualizar(int id, String novoTitulo, String novoAutor, int novoAno) throws LivroNaoEncontradoException{
		
		
			
			Optional<Livro> optionalLivro = buscarPorId(id);
			
			Livro livroParaAtualizar= optionalLivro.orElseThrow(() -> 
				new LivroNaoEncontradoException("Livro com ID " + id + " não encontrado."));
			
			livroParaAtualizar.setTitulo(novoTitulo);
			livroParaAtualizar.setAutor(novoAutor);;
			livroParaAtualizar.setAnoDePublicacao(novoAno);
			
			return livroParaAtualizar;
		
	}
	
	
	
	public void remover(int id) throws LivroNaoEncontradoException{
		boolean removido = colecao.removeIf(l -> l.getId() == id);
		
		if(!removido) {
			throw new LivroNaoEncontradoException("Livro com ID " + id + " não encontrado"); 
		}
	}
	
	public List<Livro> buscarPorTitulo(String titulo) {
        return colecao.stream()
                // Ignora maiúsculas/minúsculas e busca por parte do título
                .filter(l -> l.getTitulo().toLowerCase().contains(titulo.toLowerCase()))
                .collect(Collectors.toList());
    }
	
	public List<Livro> listarPorAno(int anoMinimo){
		return colecao.stream()
				.filter(l -> l.getAnoDePublicacao() >= anoMinimo)
				.collect(Collectors.toList());
	}
	
	public long contarTotal() {
		return colecao.stream().count();
	}
}
