<h1> Reski AI </h1>

<p> O Reski AI é uma plataforma voltada para requalificação profissional, ajudando pessoas a se prepararem para as novas demandas do mercado de trabalho. </br>
O sistema permite que o usuário cadastre seu perfil, habilidades e objetivos de carreira, e converse diretamente com uma Inteligência Artificial para poder solicitar trilhas de aprendizado alinhadas ao cargo desejado. </p>

---

## 👥 Integrantes
 
- Iris Tavares Alves 557728 </br>
- Taís Tavares Alves 557553 </br>

---

## 🎬 Vídeos

> <a href="">Vídeo Picth</a> </br>
> <a href="">Vídeo Demonstrativo</a>

---

## ⚙️ Tecnologias

- Java 17
- Spring Boot 
- Spring Data JPA
- Oracle Database (ORCL)
- Spring Validation (Bean Validation)
- Swagger / OpenAPI 
- Spring Cache
- Spring Security
- Flyway

---

### 1. Clone o repositório
```text
https://github.com/Irissuu/Reski_Ai_java.git
```

### 2. Gere uma chave JWT Key no PowerShell
```text
[Convert]::ToBase64String((1..32 | ForEach-Object { Get-Random -Minimum 0 -Maximum 256 }))
```

### 3. Configure o application.properties, coloque suas credenciais e sua JWT key
```properties
spring.application.name=2tdspm-ReskiAI
jwt.secret= # Preencha aqui

iot.api.url=https://reski-ai-iot.onrender.com

spring.datasource.url=jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL
spring.datasource.username= # Preencha aqui
spring.datasource.password= # Preencha aqui
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver

spring.jpa.database-platform=org.hibernate.dialect.OracleDialect
spring.jpa.open-in-view=false
spring.jpa.show-sql=false
spring.jpa.generate-ddl=false
spring.jpa.hibernate.ddl-auto=none

spring.flyway.enabled=true
spring.flyway.locations=classpath:db/migration

spring.flyway.table=flyway_schema_history_reski

spring.flyway.baseline-on-migrate=true
spring.flyway.baseline-version=0

```

### 4. Execute o projeto
```text
./gradlew bootRun
```

---

### ⚠️ Instruções para testar o Swagger
1. Realize o POST /auth/register para criar um usuário.

2. Em seguida faça o POST /auth/login com o email e senha cadastrados.

3. Copie o token gerado e clique em Authorize no Swagger.

4. Agora todos os endpoints protegidos estarão liberados.

---

## 🔁 Rotas Disponíveis (via Swagger)

### AuthController 

| Método | Rota            | Descrição                    |
|--------|------------------|------------------------------|
| POST   | /auth/register   | Cria novo usuário            |
| POST   | /auth/login      | Autentica e retorna token    |
| GET    | /auth/me         | Retorna usuário autenticado  |
| POST   | /auth/logout     | Remove token / encerra sessão|


### UsuarioController

| Método | Rota                 | Descrição                         |
|--------|-----------------------|-----------------------------------|
| GET    | /usuarios            | Lista todos os usuários (paginado)|
| GET    | /usuarios/{id}       | Retorna um usuário por ID         |
| PUT    | /usuarios/{id}       | Atualiza um usuário               |
| DELETE | /usuarios/{id}       | Exclui um usuário                 |



### TrilhaController

| Método | Rota             | Descrição                      |
|--------|-------------------|--------------------------------|
| GET    | /trilhas         | Lista trilhas (paginado)       |
| POST   | /trilhas         | Cria uma trilha                |
| GET    | /trilhas/{id}    | Busca trilha por ID            |
| PUT    | /trilhas/{id}    | Atualiza uma trilha            |
| DELETE | /trilhas/{id}    | Exclui uma trilha              |



### ObjetivoController

| Método | Rota               | Descrição                       |
|--------|---------------------|---------------------------------|
| GET    | /objetivos         | Lista objetivos (paginado)      |
| POST   | /objetivos         | Cria um objetivo                |
| GET    | /objetivos/{id}    | Busca objetivo por ID           |
| PUT    | /objetivos/{id}    | Atualiza um objetivo            |
| DELETE | /objetivos/{id}    | Exclui um objetivo              |



### ChatIaController

| Método | Rota      | Descrição                   |
|--------|------------|-----------------------------|
| POST   | /chat      | Gera resposta da IA         |

---

## 📧 Testes Swagger 

## ⋆˚꩜｡ USUARIO
### POST /auth/register
```text
{
  "nome": "Karina",
  "email": "karina@gmail.com",
  "senha": "MusgoCosmico",
  "cpf": "08912708171"
}
```


### POST /auth/login
```text
{
  "email": "karina@gmail.com",
  "senha": "MusgoCosmico"
}

```
## ⋆˚꩜｡ OBJETIVO
### POST /objetivos
```text
{
  "cargo": "Perito forense digital",
  "area": "Cibersegurança",
  "descricao": "Investiga incidentes de segurança, recupera e analisa dados digitais para reconstruir eventos e apresentar evidências. ",
  "demanda": "Alta e crescente"
}
```


### PUT /objetivos/{id}
```text
{
  "cargo": "Red Team",
  "area": "Cibersegurança",
  "descricao": "Profissionais que atuam de forma ofensiva, simulando adversários reais para testar a defesa da empresa. ",
  "demanda": "Alta e crescente"
}
```

## ⋆˚꩜｡ TRILHA
### POST /trilhas
```text
{
  "status": "estudando",
  "conteudo": "Direito Penal e Processual Penal",
  "competencia": "Direito Penal"
}
```


### PUT /trilhas/{id}
```text
{
  "status": "finalizado",
  "conteudo": "Direito Penal e Processual Penal",
  "competencia": "Direito Penal"
}
```

## ⋆˚꩜｡ IA
### POST /chat
```text
{
  "mensagem": "gere uma trilha de estudos para eu começar a estudar para ser cientista de dados"
}
```

---

## 🧾 Consulta no banco Oracle

Para visualizar os dados diretamente no Oracle SQL Developer, use **aspas nos nomes das tabelas**:

```sql
select * from "USUARIO_RESKI";
select * from "OBJETIVO_RESKI";
select * from "TRILHA_RESKI";
