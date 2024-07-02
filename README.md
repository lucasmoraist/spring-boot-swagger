# Swagger com Spring Boot

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Swagger](https://img.shields.io/badge/-Swagger-%23Clojure?style=for-the-badge&logo=swagger&logoColor=white)

## Descrição
Este projeto demonstra a criação de um CRUD básico para gerenciar pessoas, utilizando anotações do Swagger para documentar a API RESTful. As anotações 
fornecem descrições detalhadas dos endpoints, parâmetros, respostas e modelos de dados, facilitando a compreensão e o uso da API por desenvolvedores.

### Funcionalidades:

- **Cadastro de Pessoas:** Adiciona novas pessoas ao banco de dados.
- **Consulta de Pessoas:** Obtém todas as pessoas cadastradas ou busca por uma pessoa específica por ID.
- **Atualização de Pessoas:** Modifica os dados de uma pessoa já cadastrada.
- **Exclusão de Pessoas:** Remove uma pessoa do banco de dados.

## How to

### Pré-requisitos
- IDE de preferência (Vscode, Eclipse, Intellij)
- Java 17 ou superior
- Maven 3.2.5 ou superior

### Etapas
- Com o bash aberto dentro do diretório da pasta, rode os seguintes comandos:

```bash
mvn clean
```

```bash
mvn package
```

```bash
java -jar target/spring-boot-swagger.0.0.1-SNAPSHOT.jar
```

### Instruções de uso
- Com o programa rodando você pode fazer os testes das requisições
- Você pode usar ferramentas como o Postman ou Insomnia para testar as requisições
- Com o projeto em execução, pesquise em seu navegador por `http://localhost:8080/swagger-ui.html` lá estará a documentação e requisições criadas pelo Swagger.

## Contribuições
Acredito que faltam muitas coisas para acrescentar aqui então se sinta livre para contriubuir com este projeto. Sinta-se à vontade para enviar pull requests com melhorias, 
correções de bugs ou novos recursos.

## Contato
<a href = "mailto:luksmnt1101@gmail.com">
  <img src="https://img.shields.io/badge/-Gmail-%23333?style=for-the-badge&logo=gmail&logoColor=white" target="_blank">
</a>
<a href="https://www.linkedin.com/in/lucas-morais-152672219/" target="_blank">
  <img src="https://img.shields.io/badge/-LinkedIn-%230077B5?style=for-the-badge&logo=linkedin&logoColor=white" target="_blank">
</a>
