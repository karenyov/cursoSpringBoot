# Curso Spring Boot
Este repositório contém arquivos  que foram utilizados no Curso de Spring Boot do [Treinaweb](treinaweb.com.br).


# Passo a passo realizado (anotações)
* Para criar um projeto basta ir em File > Other > Maven > Maven Project.
obs: preencher as informações necessárias de acordo com o projeto.

* Caso o projeto apresente problemas e "warnings" Clicar com o botão direito no projeto e ir em:
Java EE Tools > Generate Deployment Descriptor Sub

- obs: esse processo é necessário para criar o web.xml.

# Configuração realizada para rodar o projeto:
* Ir em Run As > Maven build..., configuração:

- Goals: spring-boot:run

A aplicação subirá em http://localhost:8080 por padrão.

# Dependências
* Dependências Frontend no pom.xml: https://www.webjars.org/
Para atualizar as dependências, basta clicar com botão direito no projeto e ir em:
- Maven > Update Project...


# Configurações
Todas as configurações de bibliotecas, Spring Data etc, são feitas em: (src/main/resources)application.properties


# Banco de dados
As configurações do banco de dados estão em: (src/main/resources)application.properties


# Heroku
As configurações foram feitas via Heroku CLI.
* Realizado download d [Heroku CLI](https://devcenter.heroku.com/articles/heroku-cli).
* Executado passo-a-passo do [Heroku](https://devcenter.heroku.com/articles/getting-started-with-java#set-up).