USE master;

CREATE DATABASE spring_security_demo_plaintext;

USE spring_security_demo_plaintext;

drop table authorities
DROP TABLE users;

CREATE TABLE users
(
	username VARCHAR(50) NOT NULL,
	password CHAR(68) NOT NULL,
	enabled TINYINT NOT NULL,

	CONSTRAINT PK_users PRIMARY KEY (username)
	-- WITH (PAD_INDEX = OFF, 
	-- STATISTICS_NORECOMPUTE = OFF, 
	-- IGNORE_DUP_KEY = OFF, 
	-- ALLOW_ROW_LOCKS=ON,
	-- ALLOW_PAGE_LOCKS = ON) 
	-- ON [PRIMARY]
) ON [PRIMARY];

CREATE TABLE authorities
(
	username VARCHAR(50) NULL,
	authority VARCHAR(50) NULL
) ON [PRIMARY];

ALTER TABLE authorities 
	WITH CHECK ADD CONSTRAINT [FK_authorities_users] 
	FOREIGN KEY (username)
	REFERENCES users (username);

ALTER TABLE authorities 
	CHECK CONSTRAINT [FK_authorities_users];

INSERT INTO users
VALUES
	('dan1', '{noop}123', 1),
	('dan2', '{noop}123', 1),
	('dan3', '{noop}123', 1),
	('dan4', '{noop}123', 1);

UPDATE users
SET PASSWORD = '{noop}123';

INSERT INTO authorities
VALUES
	('dan1', 'ROLE_EMPLOYEE'),
	('dan2', 'ROLE_EMPLOYEE'),
	('dan2', 'ROLE_MANAGER'),
	('dan3', 'ROLE_EMPLOYEE'),
	('dan3', 'ROLE_ADMIN'),
	('dan4', 'ROLE_EMPLOYEE'),
	('dan4', 'ROLE_EMPLOYEE'),
	('dan4', 'ROLE_ADMIN');

SELECT *
FROM users;