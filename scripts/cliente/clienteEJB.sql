-- SQL Manager 2007 Lite for PostgreSQL 4.5.0.8
-- ---------------------------------------
-- Host      : localhost
-- Database  : clienteEJB
-- Version   : PostgreSQL 8.3.3, compiled by Visual C++ build 1400



CREATE SCHEMA cliente_schema AUTHORIZATION cliente;
--
-- Definition for language plpgsql (OID = 21565) : 
--
CREATE TRUSTED PROCEDURAL LANGUAGE plpgsql
   HANDLER "plpgsql_call_handler"
   VALIDATOR "pg_catalog"."plpgsql_validator";
SET check_function_bodies = false;
--
-- Structure for table cliente_table (OID = 21566) : 
--
SET search_path = cliente_schema, pg_catalog;
CREATE TABLE cliente_schema.cliente_table (
    id integer DEFAULT nextval(('"cliente_schema"."cliente_sequence"'::text)::regclass) NOT NULL,
    nome character varying(30) NOT NULL,
    endereco character varying(30) NOT NULL,
    cpf character varying(11) NOT NULL,
    telefone character varying(30) NOT NULL
) WITHOUT OIDS;
--
-- Definition for sequence cliente_sequence (OID = 21570) : 
--
CREATE SEQUENCE cliente_schema.cliente_sequence
    INCREMENT BY 1
    MAXVALUE 2147483647
    NO MINVALUE
    CACHE 1;
--
-- Structure for table fatura (OID = 21572) : 
--
CREATE TABLE cliente_schema.fatura (
    id integer DEFAULT nextval(('"cliente_schema"."fatura_sequence"'::text)::regclass) NOT NULL,
    id_pedido integer NOT NULL,
    cpf_cliente character varying(11) NOT NULL
) WITHOUT OIDS;
--
-- Definition for sequence fatura_sequence (OID = 21576) : 
--
CREATE SEQUENCE cliente_schema.fatura_sequence
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
--
-- Data for table cliente_schema.cliente_table (OID = 21566) (LIMIT 0,1)
--
INSERT INTO cliente_table (id, nome, endereco, cpf, telefone)
VALUES (1, 'Jose da Silva', 'Rua Z', '1234567', '3221-2222');

--
-- Data for table cliente_schema.fatura (OID = 21572) (LIMIT 0,3)
--
INSERT INTO fatura (id, id_pedido, cpf_cliente)
VALUES (1, 1, '1234567');

INSERT INTO fatura (id, id_pedido, cpf_cliente)
VALUES (2, 2, '1234567');

INSERT INTO fatura (id, id_pedido, cpf_cliente)
VALUES (3, 3, '1234567');

--
-- Definition for index cliente_table_pkey (OID = 21578) : 
--
ALTER TABLE ONLY cliente_table
    ADD CONSTRAINT cliente_table_pkey PRIMARY KEY (id);
--
-- Definition for index cliente_table_cpf_key (OID = 21580) : 
--
ALTER TABLE ONLY cliente_table
    ADD CONSTRAINT cliente_table_cpf_key UNIQUE (cpf);
--
-- Definition for index fatura_pkey (OID = 21582) : 
--
ALTER TABLE ONLY fatura
    ADD CONSTRAINT fatura_pkey PRIMARY KEY (id);
--
-- Data for sequence cliente_schema.cliente_sequence (OID = 21570)
--
SELECT pg_catalog.setval('cliente_sequence', 1, true);
--
-- Data for sequence cliente_schema.fatura_sequence (OID = 21576)
--
SELECT pg_catalog.setval('fatura_sequence', 3, true);
