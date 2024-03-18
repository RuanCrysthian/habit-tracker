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
git clone https://github.com/RuanCrysthian/habit-tracker.git
```
2. Execute o Docker Compose para construir e iniciar os contêineres.
```
cd habit-tracker/
docker-compose up --build -d
```
3. Importe a coleção para seu Postman.
4. A aplicação estará disponível em `http://localhost:8080`.

## API Endpoints

### API USERS
```
POST /api/users - Criar um novo usuário
GET /api/users - Recuperar todos os usuários
GET /api/users/{userId} - Recuperar determinado usuário 
UPDATE /api/users/{userId} - Atualizar usuário
DELETE /api/users/{userId} - Deletar usuário
```
**BODY**
```
{
    "name": "John",
    "username": "John.Doe",
    "email": "john.doe@dev.com",
    "password": "QAZ123qaz",
    "roles": [
        {
            "roleId":"d4e0132a-b966-4b94-8051-3496f6e8d4e5"
        },
        {
            "roleId": "f0ec7877-02f6-4240-a76a-94b3ac38f374"
        }
    ]
}
```

### API HABIT

```
POST /api/users/{userId}/habits - Criar um novo hábito
GET /api/users/{userId}/habits - Recuperar todos os hábitos de um usuário
GET /api/habits - Recuperar todos os hábitos
GET /api/habits/{habitId} - Recuperar determinado hábito 
UPDATE /api/habits/{habitId} - Atualizar hábito
DELETE /api/habits/{habitId} - Deletar hábito
GET /api/habits/{habitId}/statistics - Recuperar informações de um hábito
```
**BODY**

```
{
    "habitName": "Study",
    "description": "Study DSA",
    "startDate": "2024-03-19T16:00:00.000+00:00",
    "goal": 10
}
```

### API HABIT RECORD

```
POST /api/habits/{habitId}/habit-records - Criar um registro de hábito
GET /api/habits/{habitId}/habit-records - Recuperar todos os registros de hábito de um hábito
GET /api/habit-records - Recuperar todos os registros de hábitos.
GET /api/habit-records/{habitRecordId} - Recuperar determinado registro de hábito
UPDATE /api/habit-records/{habitRecordId} - Atualizar registro de hábito
DELETE /api/habit-records/{habitRecordId} - Deletar registro de hábito
```

**BODY**
```
{
    "status": "DONE"
}
```

## Contribuição
Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou enviar pull request.

## Licença
Este projeto está licenciado sob a MIT License.