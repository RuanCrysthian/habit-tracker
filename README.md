# Habit Tracker

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
[![Licence](https://img.shields.io/github/license/Ileriayo/markdown-badges?style=for-the-badge)](./LICENSE)

Este é um projeto de Habit Tracker desenvolvido em Spring Boot. Seu objetivo é ajudar os usuários a rastrear seus 
hábitos diários e acompanhar seu progresso ao longo do tempo.

## Funcionalidades
- Cadastro de usuários: Os usuários podem se registrar no aplicativo fornecendo um nome de usuário e uma senha.
- Gerenciamento de hábitos: Os usuários podem adicionar, visualizar, atualizar e excluir hábitos.
- Acompanhamento do progresso: Os usuários podem visualizar estatísticas sobre seu progresso na formação de hábitos.

## Tecnologias Utilizadas
- Spring Boot: Framework Java para construção de aplicativos web.
- Spring Data JPA: Facilita a interação com o banco de dados.
- PostgreSQL: Banco de dados relacional para armazenamento de dados.
- Flyway: Migração em Banco de Dados.
- Docker: Plataforma para desenvolvimento, envio e execução de aplicativos em contêineres.
- Docker Compose: Ferramenta para definir e executar aplicativos Docker com vários contêineres.
- Maven: Gerenciador de dependências.

## Pré-requisitos
- Docker instalado em sua máquina.
- Docker Compose instalado em sua máquina.

## Configuração e Execução
1. Clone o repositório
```
https://github.com/RuanCrysthian/habit-tracker.git
```
2. Execute o Docker Compose para construir e iniciar os contêineres.
```
docker-compose up --build -d
```
3. Importe a coleção para seu Postman.
4. A aplicação estará disponível em `http://localhost:8080`.

## Contribuição
Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou enviar pull request.

## Licença
Este projeto está licenciado sob a MIT License.