package SistemaDeGerenciamentoBiblioteca;

import java.util.Objects;

public class Livro {

	private int id;
	private String titulo;
	private String autor;
	private int anoDePublicacao;
	
	
	public Livro(int id, String titulo, String autor, int anoDePublicacao) {
		
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.anoDePublicacao = anoDePublicacao;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || (getClass() != obj.getClass()))
			return false;
		
		Livro livro = (Livro) obj;
		return id == livro.id;
	}
	
	
	public int getId() {
		return id;
	}
	public String getTitulo() {
		return titulo;
	}
	public String getAutor() {
		return autor;
	}
	public int getAnoDePublicacao() {
		return anoDePublicacao;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public void setAnoDePublicacao(int anoDePublicacao) {
		this.anoDePublicacao = anoDePublicacao;
	}
}