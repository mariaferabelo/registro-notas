
CREATE TABLE aluno (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    matricula VARCHAR(20) UNIQUE NOT NULL
);

CREATE TABLE disciplina (
    id_disciplina SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

CREATE TABLE avaliacao (
    id SERIAL PRIMARY KEY,
    id_aluno INT NOT NULL,
    id_disciplina INT NOT NULL,
    tipo VARCHAR(50) NOT NULL, -- Ex: Prova, Trabalho, Projeto
    nota NUMERIC(5,2) CHECK (nota >= 0 AND nota <= 10),

    CONSTRAINT fk_avaliacao_aluno FOREIGN KEY (id_aluno)
        REFERENCES aluno (id) ON DELETE CASCADE,
    CONSTRAINT fk_avaliacao_disciplina FOREIGN KEY (id_disciplina)
        REFERENCES disciplina (id_disciplina) ON DELETE CASCADE,
    CONSTRAINT uq_avaliacao UNIQUE (id_aluno, id_disciplina, tipo)
);

CREATE TABLE frequencia (
    id SERIAL PRIMARY KEY,
    id_aluno INT NOT NULL,
    id_disciplina INT NOT NULL,
    data_aula DATE NOT NULL,
    presente BOOLEAN NOT NULL, -- TRUE = presente, FALSE = falta

    CONSTRAINT fk_frequencia_aluno FOREIGN KEY (id_aluno)
        REFERENCES aluno (id) ON DELETE CASCADE,
    CONSTRAINT fk_frequencia_disciplina FOREIGN KEY (id_disciplina)
        REFERENCES disciplina (id_disciplina) ON DELETE CASCADE,
    CONSTRAINT uq_frequencia UNIQUE (id_aluno, id_disciplina, data_aula)
);


--==============
--Query de teste após inserção de aluno pelo Java
--==============
select * from aluno;