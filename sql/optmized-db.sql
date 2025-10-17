CREATE TABLE IF NOT EXISTS empresas (
    id BIGINT NOT NULL,
    nome VARCHAR(255) NOT NULL,
    cnpj VARCHAR(18) NOT NULL,
    endereco TEXT,
    phone VARCHAR(20),
    data_contratacao DATE,
    status VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS funcionario_empresa (
    id BIGINT NOT NULL,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    data_nascimento DATE,
    email VARCHAR(255),
    senha VARCHAR(255),
    cargo VARCHAR(255),
    phone VARCHAR(20),
    departamento VARCHAR(255),
    data_contratacao DATE,
    status VARCHAR(20),
    role VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS funcionario_clinica (
    id BIGINT NOT NULL,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    crm VARCHAR(50),
    data_nascimento DATE,
    email VARCHAR(255),
    senha VARCHAR(255),
    phone VARCHAR(20),
    funcao VARCHAR(255),
    especialidade VARCHAR(255),
    data_contratacao DATE,
    status VARCHAR(20),
    role VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS doencas {
    id BIGINT NOT NULL,
    nome_doenca VARCHAR(255),

}

CREATE TABLE IF NOT EXISTS consultas (
    id BIGINT NOT NULL,
    id_funcionario_empresa BIGINT NOT NULL,
    id_funcionario_clinica BIGINT NOT NULL,
    tipo_exame VARCHAR(50),
    data_hora_exame DATETIME,
    observations TEXT,
    result VARCHAR(100),
    status VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS doencas {
    id BIGINT NOT NULL,

}


CREATE TABLE IF NOT EXISTS doencas {
    id BIGINT NOT NULL,

}
