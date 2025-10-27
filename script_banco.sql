-- =====================================
-- Script de criação do banco de dados
-- Sistema: Registro de Notas e Faltas
-- =====================================

-- Criação do banco de dados
CREATE DATABASE registro_notas;

CREATE TABLE Aluno (
    id_aluno SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    matricula VARCHAR(20) UNIQUE NOT NULL
);

CREATE TABLE Disciplina (
    id_disciplina SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

CREATE TABLE Avaliacao (
    id_avaliacao SERIAL PRIMARY KEY,
    id_aluno INT NOT NULL,
    id_disciplina INT NOT NULL,
    tipo VARCHAR(50) NOT NULL, -- Ex: Prova, Trabalho, Projeto
    nota NUMERIC(5,2) CHECK (nota >= 0 AND nota <= 10),
     FOREIGN KEY (id_aluno) REFERENCES Aluno(id_aluno) ON DELETE CASCADE,
    FOREIGN KEY (id_disciplina) REFERENCES Disciplina(id_disciplina) ON DELETE CASCADE
);

CREATE TABLE Frequencia (
    id_frequencia SERIAL PRIMARY KEY,
    id_aluno INT NOT NULL,
    id_disciplina INT NOT NULL,
    data_aula DATE NOT NULL,
    presente BOOLEAN NOT NULL,
    FOREIGN KEY (id_aluno) REFERENCES Aluno(id_aluno) ON DELETE CASCADE,
    FOREIGN KEY (id_disciplina) REFERENCES Disciplina(id_disciplina) ON DELETE CASCADE
);
