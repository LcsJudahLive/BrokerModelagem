CREATE TABLE login(
	cpf VARCHAR(11) NOT NULL,
	password VARCHAR(50) NULL
);

CREATE TABLE carteira(
	cpf VARCHAR(11) NOT NULL,
	valor_conta DOUBLE NULL
);

CREATE TABLE conta(
	cpf VARCHAR(11) NOT NULL,
	codigo_empresa VARCHAR(10) NULL,
	valor_conta INT NULL,
	preco FLOAT NULL
);

INSERT INTO login (cpf, password) VALUES ('00000000000', '000');