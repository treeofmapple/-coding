\echo 'Step 0: Preparing database for fast import...'

\echo 'Step 0.1: Enabling pg_cron extension...'

CREATE EXTENSION IF NOT EXISTS pg_cron;

\echo 'Step 1: Creating tables...'

CREATE TYPE tipo_exame_enum AS ENUM (
    'ASO Admissional',
    'ASO Periódico',
    'ASO Demissional',
    'ASO de Retorno ao Trabalho',
    'Audiometria',
    'Espirometria',
    'Acuidade Visual',
    'Hemograma Completo',
    'Glicemia de Jejum',
    'Raio-X de Tórax',
    'Eletrocardiograma (ECG)',
    'Eletroencefalograma (EEG)',
    'Exame de Urina (EAS)',
    'Exame de Fezes',
    'Colesterol Total e Frações',
    'Triglicerídeos',
    'Ureia e Creatinina',
    'Teste Ergométrico',
    'Exame Toxicológico',
    'Exame de Colesterol HDL/LDL',
    'Exame de Função Hepática',
    'Exame de Função Renal',
    'Exame Clínico Geral',
    'Teste de COVID-19',
    'Raio-X de Coluna',
    'Ultrassonografia Abdominal',
    'Exame de Sangue Completo',
    'Sorologia para Hepatites',
    'Exame de PSA',
    'Exame Ginecológico',
    'Exame de Gravidez',
    'Teste de Glicose Pós-Prandial',
    'Curva Glicêmica',
    'Exame Oftalmológico',
    'Exame Otorrinolaringológico',
    'Exame Dermatológico Ocupacional',
    'Exame de Colesterol Total',
    'Hemoglobina Glicada',
    'Exame de Função Pulmonar'
);

CREATE TABLE IF NOT EXISTS empresas (
    id BIGINT NOT NULL,
    nome VARCHAR(255) NOT NULL,
    cnpj VARCHAR(18) NOT NULL,
    endereco VARCHAR(255),
    email VARCHAR(100),
    telefone VARCHAR(25),
    data_contratacao DATE,
    status VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS clinicas (
    id BIGINT NOT NULL,
    nome VARCHAR(255) NOT NULL,
    cnpj VARCHAR(18) NOT NULL,
    endereco VARCHAR(255),
    email VARCHAR(100),
    telefone VARCHAR(25),
    data_contratacao DATE,
    status VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS funcionarios (
    id BIGINT NOT NULL,
    id_empresas BIGINT NOT NULL,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    data_nascimento DATE,
    endereco VARCHAR(255),
    email VARCHAR(255),
    senha VARCHAR(255),
    telefone VARCHAR(25),
    cargo VARCHAR(255),
    setor VARCHAR(255),
    data_contratacao DATE,
    status VARCHAR(20),
    role VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS medicos (
    id BIGINT NOT NULL,
    id_clinicas BIGINT NOT NULL,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    crm VARCHAR(50) NOT NULL,
    data_nascimento DATE,
    endereco VARCHAR(255),
    email VARCHAR(255),
    senha VARCHAR(255),
    telefone VARCHAR(25),
    especialidade VARCHAR(255),
    setor VARCHAR(255),
    data_contratacao DATE,
    status VARCHAR(20),
    role VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS doencas {
    id BIGINT NOT NULL,
    nome VARCHAR(255),
    grau VARCHAR(50),
    primeira_ocorrencia DATE
}

CREATE TABLE risco_ocupacional (
    id BIGINT NOT NULL,
    descricao VARCHAR(150) NOT NULL,
    categoria VARCHAR(100),
    tratamento VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS consultas (
    id BIGINT NOT NULL,
    id_funcionario BIGINT NOT NULL,
    id_medico BIGINT NOT NULL,
    id_doencas BIGINT NOT NULL,
    id_risco_ocupacional BIGINT,
    tipo_exame tipo_exame_enum NOT NULL,
    data_hora_exame TIMESTAMP,
    observations TEXT,
    result VARCHAR(100),
    status VARCHAR(100)
);

\echo 'Creating materialized views'

CREATE MATERIALIZED VIEW IF NOT EXISTS quantidade_funcionarios_total AS
SELECT
    f.id_empresa,
    e.nome AS nome_empresa,
    COUNT(f.id) AS total_funcionarios,
    MAX(f.data_contratacao) AS ultima_contratacao
FROM funcionarios f
JOIN empresas e ON f.id_empresa = e.id
GROUP BY f.id_empresa, e.nome;

CREATE MATERIALIZED VIEW IF NOT EXISTS primeira_ocorrencia_doencas AS
SELECT
    d.id AS id_doenca,
    d.nome AS nome_doenca,
    f.nome AS primeiro_funcionario,
    MIN(c.data_hora_exame) AS data_primeira_ocorrencia
FROM consultas c
JOIN doencas d ON c.id_doencas = d.id
JOIN funcionarios f ON c.id_funcionario = f.id
GROUP BY d.id, d.nome, f.nome
ORDER BY data_primeira_ocorrencia ASC;

SELECT cron.schedule('refresh_material_views', '0 3 * * *', $$
    REFRESH MATERIALIZED VIEW CONCURRENTLY quantidade_funcionarios_total;
    REFRESH MATERIALIZED VIEW CONCURRENTLY primeira_ocorrencia_doencas;
$$);

SELECT jobid, schedule, command, nodename, nodeport, database, username
FROM cron.job;

\ echo 'Finished creating views'

\echo 'Step 3: Starting data import...'
\timing on
\echo 'Importing empresas...'

COPY empresas(
id,
nome,
cnpj,
endereco,
email,
telefone,
data_contratacao,
status
);
FROM '/docker-entrypoint-initdb.d/empresas.csv'
WITH (FORMAT csv, HEADER true);

COPY clinicas(
id,
nome,
cnpj,
endereco,
email,
telefone,
data_contratacao,
status
);
FROM '/docker-entrypoint-initdb.d/funcionario.csv'
WITH (FORMAT csv, HEADER true);

COPY funcionario(
id,
id_empresas,
nome,
cpf,
data_nascimento,
endereco,
email,
senha,
telefone,
cargo,
setor,
data_contratacao,
status,
role
);
FROM '/docker-entrypoint-initdb.d/funcionario.csv'
WITH (FORMAT csv, HEADER true);

COPY medicos(
id,
id_clinicas,
nome,
cpf,
crm,
data_nascimento,
endereco,
email,
senha,
telefone,
especialidade,
setor,
data_contratacao,
status,
role
);
FROM '/docker-entrypoint-initdb.d/medicos.csv'
WITH (FORMAT csv, HEADER true);

COPY doencas(
id,
nome,
grau,
primeira_ocorrencia
);
FROM '/docker-entrypoint-initdb.d/doencas.csv'
WITH (FORMAT csv, HEADER true);

COPY risco_ocupacional(
id,
descricao,
categoria,
tratamento
);
FROM '/docker-entrypoint-initdb.d/risco_ocupacional.csv'
WITH (FORMAT csv, HEADER true);

COPY consultas(
id,
id_funcionario,
id_medico,
id_doencas,
id_risco_ocupacional,
tipo_exame,
data_hora_exame,
observations,
result,
status
);
FROM '/docker-entrypoint-initdb.d/consultas.csv'
WITH (FORMAT csv, HEADER true);

\timing off
\echo 'All data imported successfully.'
\echo 'Step 4: Adding primary keys, unique constraints, and foreign keys...'

\echo 'Step 4.1: Adding primary keys and unique constraints'

ALTER TABLE empresas ADD CONSTRAINT empresas_pkey PRIMARY KEY (id);
ALTER TABLE empresas ADD CONSTRAINT empresas_cnpj_unique UNIQUE (cnpj);

ALTER TABLE clinicas ADD CONSTRAINT clinicas_pkey PRIMARY KEY (id);
ALTER TABLE clinicas ADD CONSTRAINT clinicas_cnpj_unique UNIQUE (cnpj);

ALTER TABLE funcionarios ADD CONSTRAINT funcionarios_pkey PRIMARY KEY (id);
ALTER TABLE funcionarios ADD CONSTRAINT funcionarios_cpf_unique UNIQUE (cpf);

ALTER TABLE medicos ADD CONSTRAINT medicos_pkey PRIMARY KEY (id);
ALTER TABLE medicos ADD CONSTRAINT medicos_cpf_unique UNIQUE (cpf);
ALTER TABLE medicos ADD CONSTRAINT medicos_crm_unique UNIQUE (crm);

ALTER TABLE doencas ADD CONSTRAINT doencas_pkey PRIMARY KEY (id);
ALTER TABLE risco_ocupacional ADD CONSTRAINT risco_ocupacional_pkey PRIMARY KEY (id);
ALTER TABLE consultas ADD CONSTRAINT consultas_pkey PRIMARY KEY (id);

\echo 'Step 4.2: Adding foreign keys...'

ALTER TABLE funcionarios
    ADD CONSTRAINT funcionarios_empresa_fk
    FOREIGN KEY (id_empresa) REFERENCES empresas(id) ON DELETE CASCADE;

ALTER TABLE medicos
    ADD CONSTRAINT medicos_clinica_fk
    FOREIGN KEY (id_clinica) REFERENCES clinicas(id) ON DELETE CASCADE;

ALTER TABLE consultas
    ADD CONSTRAINT consultas_funcionario_fk
    FOREIGN KEY (id_funcionario) REFERENCES funcionarios(id) ON DELETE CASCADE,
    ADD CONSTRAINT consultas_medico_fk
    FOREIGN KEY (id_medico) REFERENCES medicos(id) ON DELETE CASCADE,
    ADD CONSTRAINT consultas_doenca_fk
    FOREIGN KEY (id_doencas) REFERENCES doencas(id) ON DELETE SET NULL,
    ADD CONSTRAINT consultas_risco_fk
    FOREIGN KEY (id_risco_ocupacional) REFERENCES risco_ocupacional(id) ON DELETE SET NULL;

\echo 'All constraints and keys added.'
\echo 'Step 5: Setting up auto-increment and IDENTITY CONFIG...'

ALTER TABLE empresas ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY;
ALTER TABLE clinicas ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY;
ALTER TABLE funcionarios ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY;
ALTER TABLE medicos ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY;
ALTER TABLE doencas ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY;
ALTER TABLE risco_ocupacional ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY;
ALTER TABLE consultas ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY;

\echo 'Auto-increment configured.'

CREATE INDEX IF NOT EXISTS idx_funcionarios_email ON funcionarios (email);
CREATE INDEX IF NOT EXISTS idx_medicos_email ON medicos (email);
CREATE INDEX IF NOT EXISTS idx_medicos_crm ON medicos(crm);
CREATE INDEX IF NOT EXISTS idx_consultas_tipo_exame ON consultas (tipo_exame);

\echo 'Indexation Configured.'

\echo 'Step 6: Running ANALYZE...'
ANALYZE;
\echo 'Analyze complete.'

\echo 'Step 7: Resetting identity sequences...'


SELECT setval(pg_get_serial_sequence('empresas', 'id'),
              COALESCE((SELECT MAX(id) FROM empresas), 1));
SELECT setval(pg_get_serial_sequence('clinicas', 'id'),
              COALESCE((SELECT MAX(id) FROM clinicas), 1));
SELECT setval(pg_get_serial_sequence('funcionarios', 'id'),
              COALESCE((SELECT MAX(id) FROM funcionarios), 1));
SELECT setval(pg_get_serial_sequence('medicos', 'id'),
              COALESCE((SELECT MAX(id) FROM medicos), 1));
SELECT setval(pg_get_serial_sequence('doencas', 'id'),
              COALESCE((SELECT MAX(id) FROM doencas), 1));
SELECT setval(pg_get_serial_sequence('risco_ocupacional', 'id'),
              COALESCE((SELECT MAX(id) FROM risco_ocupacional), 1));
SELECT setval(pg_get_serial_sequence('consultas', 'id'),
              COALESCE((SELECT MAX(id) FROM consultas), 1));

\echo 'Identity sequences reset successfully.'

BEGIN
    PERFORM pg_sleep(10);
END $$;

\echo 'Database initialization complete!'
