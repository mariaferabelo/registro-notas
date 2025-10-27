# Registro de Notas e Faltas

Este projeto implementa um sistema distribuído para gerenciamento de notas e faltas de alunos, utilizando **Java RMI (Remote Method Invocation)**.
O sistema possui uma interface gráfica no lado do cliente, um servidor que gerencia o banco de dados e comunicação remota, e um script SQL para criação e inicialização do banco de dados. 
O projeto foi desenvolvido para a Disciplina de Sistemas Distribuídos e com o intuito de atender aos requisitos de uma aplicação distribuída com as entidades **Aluno**, **Disciplina**, **Avaliação** e **Frequência**.

## Requisitos
- **Java**: JDK 17 ou superior
- **Banco de Dados**: Postgre
- **Driver JDBC**: Para conexão com o banco (ex.: `mysql-connector-java`)
- **Ambiente**: Duas máquinas (ou localhost para testes) para cliente e servidor
- **IDE**: Recomenda-se NetBeans para compilar e executar o projeto
- **Git**: Para clonar e gerenciar o repositório

## Funcionalidades
- **Cliente**: Interface gráfica (usando Swing) para:
  - Cadastrar e consultar alunos.
  - Gerenciar disciplinas, avaliações e frequências.
  - Visualizar notas e faltas de alunos por disciplina.
- **Servidor**: Implementa a lógica de negócios via RMI e gerencia o banco de dados:
  - Armazena e recupera dados de **Aluno**, **Disciplina**, **Avaliação** e **Frequência**.
  - Responde às chamadas remotas do cliente.
- **Banco de Dados**: Contém tabelas para as entidades mencionadas, com relacionamentos adequados.

## Entidades do Banco de Dados
- **Aluno**: Armazena informações dos alunos (ex.: ID, nome, matrícula).
- **Disciplina**: Contém dados das disciplinas (ex.: ID, nome).
- **Avaliação**: Registra notas dos alunos em disciplinas (ex.: ID, aluno, disciplina, nota, data).
- **Frequência**: Registra a presença/falta dos alunos em aulas (ex.: ID, aluno, disciplina, data, status).
