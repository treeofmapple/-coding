CREATE TABLE IF NOT EXISTS admin (
    id SERIAL PRIMARY KEY,
    username VARCHAR(18) NOT NULL,
    password VARCHAR(255) NOT NULL, 
    access_date DATE
);

CREATE TABLE IF NOT EXISTS policeOfficer (
    id SERIAL PRIMARY KEY,
    username VARCHAR(18) NOT NULL,
    password VARCHAR(255) NOT NULL,
    position VARCHAR(100) NOT NULL,
    gender CHAR(1) CHECK (gender IN ('M', 'F')),
    time_worked INT DEFAULT 0, 
    people_arrested INT DEFAULT 0, 
    started_time DATE,
    active BOOLEAN, 
    access_date DATE
);

CREATE TABLE IF NOT EXISTS criminal (
    criminalID SERIAL PRIMARY KEY,
    firstName VARCHAR(255) NOT NULL,
    lastName VARCHAR(255) NOT NULL,
    gender CHAR(1) CHECK (gender IN ('M', 'F')),
    due VARCHAR(25),
    image VARCHAR(255),
    arrest_time DATE,
    arrested BOOLEAN DEFAULT FALSE,
    set_Arrest BOOLEAN DEFAULT FALSE
);


INSERT INTO admin (username, password) VALUES ('admin', 'admin123');

INSERT INTO policeOfficer (username, password, position) VALUES ('Polska', 'vodkaLife', 'Detective');
INSERT INTO policeOfficer (username, password, position) VALUES ('Admeir', 'vodkaLife', 'Deputy');

SELECT * FROM admin;

-- Função para verificar o acesso do usuário com base na posição
CREATE OR REPLACE FUNCTION check_access(username VARCHAR(18))
RETURNS BOOLEAN AS $$
DECLARE
    user_position VARCHAR(100);
BEGIN
    SELECT position INTO user_position FROM policeOfficer WHERE username = username;
    IF user_position = 'Delegado' THEN
        RETURN TRUE;
    ELSIF user_position = 'Escrivão' OR user_position = 'Investigador' OR user_position = 'Perito Criminal' THEN
        RETURN FALSE;
    ELSE
        RAISE EXCEPTION 'Posição de usuário desconhecida';
    END IF;
END;
$$ LANGUAGE plpgsql;

-- Função para verificar se a taxa foi paga
CREATE OR REPLACE FUNCTION check_due_payment(username VARCHAR(18))
RETURNS VARCHAR(10) AS $$
DECLARE
    user_due VARCHAR(25);
BEGIN
    SELECT due INTO user_due FROM criminal WHERE username = username;
    IF user_due = 'Paga' THEN
        RETURN 'Pago';
    ELSE
        RETURN 'Não Pago';
    END IF;
END;
$$ LANGUAGE plpgsql;

-- Função para definir arrested como true quando set_arrest for false e tiver uma arrest_time
CREATE OR REPLACE FUNCTION update_arrest_status()
RETURNS VOID AS $$
BEGIN
    UPDATE criminal
    SET arrested = TRUE
    WHERE set_arrest = FALSE AND arrest_time IS NOT NULL;
END;
$$ LANGUAGE plpgsql;

-- Função para inserir a data de acesso
CREATE OR REPLACE FUNCTION update_access_date(username VARCHAR(18))
RETURNS VOID AS $$
BEGIN
    UPDATE admin
    SET access_date = NOW()
    WHERE username = 'admin';

    UPDATE policeOfficer
    SET access_date = NOW()
    WHERE username = username;
END;
$$ LANGUAGE plpgsql;


-- Exemplo de uso:
-- Para verificar o acesso de um usuário 'user1':

-- SELECT check_access('user1');


-- Para verificar o pagamento da taxa de um criminoso 'criminal1':

-- SELECT check_due_payment('criminal1');


-- Para definir arrested como true quando set_arrest for false e tiver uma arrest_time:
-- SELECT update_arrest_status();


-- Para atualizar a data de acesso do usuário 'admin':

-- SELECT update_access_date('admin');


-- Para atualizar a data de acesso de um policial 'user1':

-- SELECT update_access_date('user1');

