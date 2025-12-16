package SistemaDeGerenciamentoBiblioteca;

public class Main {

	
	public static void main(String[] args) {
		
		
		GerenciadorDeLivros gerenciador = new GerenciadorDeLivros();
		
		System.out.println("-- 1. Adicionar Livros --");
		gerenciador.adicionar("Java para Leigos", "Barry Burd", 2019);
        gerenciador.adicionar("Effective Java", "Joshua Bloch", 2018);
        gerenciador.adicionar("Clean Code", "Robert C. Martin", 2008);
        gerenciador.adicionar("Java Avançado com Streams", "Maria Silva", 2023);
        System.out.printf("Total de livros após adição: %d\n", gerenciador.contarTotal());
		
		
        System.out.println("\n-- 2. Lista Completa --");
        gerenciador.listarTodos()
        	.forEach(l -> System.out.printf("ID: %d | Título: %s | Ano: %d \n", l.getId(), l.getTitulo(), l.getAnoDePublicacao()));
        
        
    
        System.out.println("\n--- 3. Streams e Optional ---");

        
        System.out.println("Busca por 'Java':");
        gerenciador.buscarPorTitulo("Java").forEach(l -> 
            System.out.printf("Título Encontrado: %s\n", l.getTitulo()));

        
        System.out.println("\nLivros publicados a partir de 2020:");
        gerenciador.listarPorAno(2020).forEach(l -> 
            System.out.printf("Título: %s | Ano: %d\n", l.getTitulo(), l.getAnoDePublicacao()));
        
        
        gerenciador.buscarPorId(2).ifPresentOrElse(
            l -> System.out.printf("\nOptional: Livro ID 2 encontrado: %s\n", l.getTitulo()),
            () -> System.out.println("\nOptional: Livro não encontrado.")
        );
        
     
        System.out.println("\n--- 4. Atualização e Exceptions ---");
        try {
            
            gerenciador.atualizar(1, "Java para Todos", "Barry Burd Atualizado", 2021);
            System.out.println("Livro ID 1 atualizado com sucesso.");
            
           
        } catch (LivroNaoEncontradoException e) {
            System.err.println("Erro Checked: " + e.getMessage());
        }

    
        System.out.println("\n--- 5. Remoção e Exceptions ---");
        try {
            
            gerenciador.remover(3);
            System.out.println("Livro ID 3 removido com sucesso.");
            System.out.printf("Total de livros após remoção: %d\n", gerenciador.contarTotal()); 

          
        } catch (LivroNaoEncontradoException e) {
            System.err.println("Erro Checked: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Erro Unchecked: " + e.getMessage());
        }
        
      
        System.out.println("\n--- Lista Final ---");
        gerenciador.listarTodos().forEach(l -> 
            System.out.printf("ID: %d | Título: %s\n", l.getId(), l.getTitulo()));
	}
}
