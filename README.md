# Indice

- [Sobre](#-sobre)
- [Tecnologias Utilizadas](#-tecnologias-utilizadas)
- [Como baixar o projeto](#-como-baixar-o-projeto)
- [Requerimentos](#requerimentos)


## ☀️ Sobre

A idéia é obter informações completa dos filmes de fontes públicas com o WebService [OMDBAPI](http://www.omdbapi.com)
através do titulo,  
 O usuário pode criar listas de desejos baseado no retorno da consulta do WebService e sobre estas pode avaliar com notas de 5 a 10, aplicar 1 a 5 estrelas para os filmes e adicionar comentários. Ele pode adicionar, atualizar e remover sua nota, quantidade de estrelas e comentários, mas não pode repetir os mesmos comentários por filme.    
 
 
## 💻 Tecnologias utilizadas

- [Java11](https://www.oracle.com/br/java/technologies/javase-jdk11-downloads.html)
- [DevTools](https://developers.google.com/web/tools/chrome-devtools)
- [Spring-tools-Suite-4](https://spring.io/tools) 
- [Maven](https://maven.apache.org/)
- [Swagger](https://swagger.io/)
- [Servidor-Tomcat](http://tomcat.apache.org/)
- [PostgreSQL-12](https://www.postgresql.org/)
- [JPA](https://www.postgresql.org/)
 
 
## Requirementos
- [Java11](https://nodejs.org/en/) 
- [PostgreSQL](https://www.postgresql.org/)

## 📁 Como baixar e usar o projeto

```bash
# clonar repositório
$ git clone https://github.com/code-challenge-projects/wagneer-nasc-java-rest-api/tree/wagneer-nascimento-desafio

# Instalar as libs
$ Maven Update
$ Maven Clean
$ Maven Install
 
# inicar o projeto
$ Starter
$ localhost:8080/coloque a rota aqui


```
## 📁 Serviços disponibilizado na API
BASE_URL -> http://localhost:8080   
Metodo GET, Param Titulo  
Consumindo um webService de terceiros  
http://localhost:8080/ws/filmes/titulo  

```bash
 http://localhost:8080/ws/filmes/rambo  
{
  "Title": "Rambo",
  "Year": "2008",
  "Released": "25 Jan 2008",
  "Genre": "Action, Thriller",
  "Director": "Sylvester Stallone",
  "Writer": "Art Monterastelli, Sylvester Stallone, David Morrell (character)",
  "Actors": "Sylvester Stallone, Julie Benz, Matthew Marsden, Graham McTavish",
  "Plot": "In Thailand, John Rambo joins a group of mercenaries to venture into war-torn Burma, and rescue a group of Christian aid workers who were kidnapped by the ruthless local infantry unit.",
  "Language": "English, Burmese, Thai",
  "Country": "Germany, USA, Thailand",
  "Awards": "1 win & 1 nomination.",
  "Poster": "https://m.media-amazon.com/images/M/MV5BMTI5Mjg1MzM4NF5BMl5BanBnXkFtZTcwNTAyNzUzMw@@._V1_SX300.jpg",
  "imdbID": "tt0462499",
  "Type": "movie",
  "Production": "Lionsgate Films",
  "Response": true
}
```
Criando minha Lista de desejos de filmes  
Metodo POST http://localhost:8080/filmes  
Request body   

```bash
{
    "titulo": "filmes de acao",
    "status": 0,
    "filmes": [
      { 
        "id_filme": "tt0462499"
      },
      { 
        "id_filme": "tt0118615"
      }]
}

Response Code 201  

{
  "id": 1,
  "titulo": "filmes de acao123",
  "status": "PRIVADO",
  "filmes": [
    {
      "id_filme": "tt0118615",
      "titulo": "Anaconda",
      "ano_lancamento": "1997",
      "liberado": "11 Apr 1997",
      "genero": "Action, Adventure, Horror, Thriller",
      "diretor": "Luis Llosa",
      "escritor": "Hans Bauer, Jim Cash, Jack Epps Jr.",
      "atores": "Jennifer Lopez, Ice Cube, Jon Voight, Eric Stoltz",
      "enredo": "A \"National Geographic\" film crew is taken hostage by an insane hunter, who forces them along on his quest to capture the world's largest - and deadliest - snake.",
      "lingua": "English",
      "pais": "USA",
      "premios": "6 wins & 11 nominations.",
      "image_cartaz": "https://m.media-amazon.com/images/M/MV5BZDc4ODcyNWMtMzI2Zi00YzcwLWE4ZTUtYWM3OWI1MTgwYTc1XkEyXkFqcGdeQXVyNzc5MjA3OA@@._V1_SX300.jpg",
      "tipo": "movie",
      "producao": "Columbia Pictures Corporation",
      "comentarios": [],
      "avaliacoes": [],
      "estrelas": []
    },
    {
      "id_filme": "tt0462499",
      "titulo": "Rambo",
      "ano_lancamento": "2008",
      "liberado": "25 Jan 2008",
      "genero": "Action, Thriller",
      "diretor": "Sylvester Stallone",
      "escritor": "Art Monterastelli, Sylvester Stallone, David Morrell (character)",
      "atores": "Sylvester Stallone, Julie Benz, Matthew Marsden, Graham McTavish",
      "enredo": "In Thailand, John Rambo joins a group of mercenaries to venture into war-torn Burma, and rescue a group of Christian aid workers who were kidnapped by the ruthless local infantry unit.",
      "lingua": "English, Burmese, Thai",
      "pais": "Germany, USA, Thailand",
      "premios": "1 win & 1 nomination.",
      "image_cartaz": "https://m.media-amazon.com/images/M/MV5BMTI5Mjg1MzM4NF5BMl5BanBnXkFtZTcwNTAyNzUzMw@@._V1_SX300.jpg",
      "tipo": "movie",
      "producao": "Lionsgate Films",
      "comentarios": [],
      "avaliacoes": [],
      "estrelas": []
    }
  ]
}
```  
Metodo GET Minha lista de desejos, podendo passar o id no parametro para procurar uma especifica  
http://localhost:8080/desejos   -> lista todos os desejos  
http://localhost:8080/desejos/1 -> lista uma especifica  

```bash 
response code 200


[
  {
    "id": 1,
    "titulo": "filmes de acao123",
    "status": "PRIVADO",
    "filmes": [
      {
        "id_filme": "tt0118615",
        "titulo": "Anaconda",
        "ano_lancamento": "1997",
        "liberado": "11 Apr 1997",
        "genero": "Action, Adventure, Horror, Thriller",
        "diretor": "Luis Llosa",
        "escritor": "Hans Bauer, Jim Cash, Jack Epps Jr.",
        "atores": "Jennifer Lopez, Ice Cube, Jon Voight, Eric Stoltz",
        "enredo": "A \"National Geographic\" film crew is taken hostage by an insane hunter, who forces them along on his quest to capture the world's largest - and deadliest - snake.",
        "lingua": "English",
        "pais": "USA",
        "premios": "6 wins & 11 nominations.",
        "image_cartaz": "https://m.media-amazon.com/images/M/MV5BZDc4ODcyNWMtMzI2Zi00YzcwLWE4ZTUtYWM3OWI1MTgwYTc1XkEyXkFqcGdeQXVyNzc5MjA3OA@@._V1_SX300.jpg",
        "tipo": "movie",
        "producao": "Columbia Pictures Corporation",
        "comentarios": [],
        "avaliacoes": [],
        "estrelas": []
      },
    ]
  }
]
```
Voce podera adicionar, alterar e remover,   
Avaliacao, Notas e comentarios , mas nao poderá adicionar comentarios repetidos por filme.

```bash  
METODO POST    
http://localhost:8080/comentarios/tt0118615    
 

{
	"descricao": "muito bacana esse filme"
}
 

METODO POST  
http://localhost:8080/avaliacoes/tt0118615  
   
{
	"avaliacao": 5
}

 
METODO POST  
http://localhost:8080/estrelas/tt0118615  
 
{
	"estrela": 5
}
```  
 

### 😁  Contato , Dúvidas .
- Linkedin [Wagner Nascimento .](https://www.linkedin.com/in/wagner-nascimento-8824b717b/)