#Gerenciamento de Livros em Memória: Aplicação Core Java
Este projeto é uma aplicação de Console simples, construída em Core Java, que simula um CRUD (Create, Read, Update, Delete) para gerenciamento de uma coleção de livros em memória. Ele foi desenvolvido com o objetivo de consolidar conceitos essenciais da Programação Orientada a Objetos (POO) e do ecossistema de Collections e Streams do Java.

✨ Conceitos Aplicados
O projeto é a materialização de diversos tópicos fundamentais da linguagem Java:

Programação Orientada a Objetos (POO): Utilização de classes (Livro, GerenciadorDeLivros), objetos e o princípio de Encapsulamento (atributos privados com getters e setters).

Contratos de Igualdade: Implementação correta dos métodos equals() e hashCode() na classe Livro, garantindo que a comparação de objetos seja baseada em seu ID único.

Coleções: Uso da interface List e sua implementação ArrayList para armazenar e gerenciar a coleção de objetos Livro.

Streams API (Java 8+): Utilização da API de Streams para manipular a lista de objetos de forma funcional, incluindo operações de:

filter (para buscar por título ou ano de publicação).

findFirst (na busca por ID).

count (para obter o total de livros).

collect (para retornar listas filtradas).

Tratamento de Exceções:

Implementação de uma Exceção Checked (LivroNaoEncontradoException) para lidar com tentativas de busca/atualização/remoção de IDs inexistentes.

Uso de Exceção Unchecked (IllegalArgumentException) para validar regras de negócio (e.g., título ou autor não podem ser vazios).

Optional: Uso da classe Optional<Livro> no método de busca por ID para prevenir erros de NullPointerException e promover um código mais seguro e expressivo.

