# Med Voll API

Este repositório contém a implementação da Voll Med API, projeto desenvolvido como parte do escopo do curso "Spring Boot 3: desenvolva uma API Rest em Java" da Alura. O código foi construído com foco na aplicação e documentação de práticas de desenvolvimento back-end corporativo.

## Visão Geral

A aplicação é uma API RESTful projetada para o gerenciamento de uma clínica médica. Ela expõe endpoints para as operações de CRUD de médicos e pacientes, garantindo a validação de dados de entrada, persistência segura e aplicação de padrões de projeto do ecossistema Spring.

## Stack Tecnológica

* **Java 17**
* **Spring Boot 3** (Web, Data JPA, Validation)
* **MySQL**
* **Flyway**
* **Lombok**
* **Maven**

## Padrões e Arquitetura Aplicados

* **Design Pattern DTO (Data Transfer Object):** Utilização de Java Records para tráfego seguro de dados entre as requisições e a aplicação, isolando o modelo de domínio.
* **Rich Domain Model:** Delegação de comportamentos e regras de mudança de estado para as próprias entidades, evitando o modelo anêmico.
* **Gerenciamento de Transações:** Controle de persistência utilizando `@Transactional` e o mecanismo de *Dirty Checking* do Hibernate.
* **Exclusão Lógica (Soft Delete):** Inativação de registros (`ativo = false`) para manutenção de histórico e integridade referencial no banco de dados.
* **Migrations estruturadas:** Controle de versão do banco de dados relacional através do Flyway (`V1` a `V5`).
* **Paginação nativa:** Padronização de respostas de listagem em massa utilizando a interface `Pageable` do Spring Data.

## Instruções de Execução

**Pré-requisitos:** Java 17+ e MySQL instalados localmente.

1. Clone o repositório:
   ```bash
   git clone [https://github.com/gluizdev04/med.voll.git](https://github.com/gluizdev04/med.voll.git)

2. Configure a conexão com o banco de dados. Você pode exportar as variáveis de ambiente no seu sistema operacional ou defini-las diretamente no application.properties:
   ```bash
   spring.datasource.url=jdbc:mysql://${MS_HOST}/vollmed_api
   spring.datasource.username=${MS_USER}
   spring.datasource.password=${MS_PASSWORD}
