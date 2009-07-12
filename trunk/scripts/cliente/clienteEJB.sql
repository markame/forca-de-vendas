-- SQL Manager 2007 Lite for PostgreSQL 4.3.0.4
-- ---------------------------------------
-- Host      : localhost
-- Database  : clienteEJB
-- Version   : PostgreSQL 8.3.3, compiled by Visual C++ build 1400


CREATE SCHEMA cliente_schema AUTHORIZATION componente;
--
-- Definition for language plpgsql (OID = 16386) : 
--
CREATE TRUSTED PROCEDURAL LANGUAGE plpgsql
   HANDLER "plpgsql_call_handler"
;
SET check_function_bodies = false;
--
-- Structure for table cliente_table (OID = 16409) : 
--
SET search_path = cliente_schema, pg_catalog;
CREATE TABLE cliente_schema.cliente_table (
    id integer DEFAULT nextval(('"cliente_schema"."cliente_sequence"'::text)::regclass) NOT NULL,
    nome character varying(30) NOT NULL,
    endereco character varying(30) NOT NULL,
    cpf character varying(11) NOT NULL,
    telefone character varying(30) NOT NULL
);
--
-- Definition for sequence cliente_sequence (OID = 16413) : 
--
CREATE SEQUENCE cliente_schema.cliente_sequence
    INCREMENT BY 1
    MAXVALUE 2147483647
    NO MINVALUE
    CACHE 1;
--
-- Structure for table fatura (OID = 16420) : 
--
CREATE TABLE cliente_schema.fatura (
    id integer DEFAULT nextval(('"cliente_schema"."fatura_sequence"'::text)::regclass) NOT NULL,
    "idItem" integer NOT NULL,
    quantide integer NOT NULL
);
--
-- Definition for sequence fatura_sequence (OID = 16425) : 
--
CREATE SEQUENCE cliente_schema.fatura_sequence
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
--
-- Definition for index cliente_table_pkey (OID = 16415) : 
--
ALTER TABLE ONLY cliente_table
    ADD CONSTRAINT cliente_table_pkey PRIMARY KEY (id);
--
-- Definition for index cliente_table_cpf_key (OID = 16417) : 
--
ALTER TABLE ONLY cliente_table
    ADD CONSTRAINT cliente_table_cpf_key UNIQUE (cpf);
--
-- Definition for index fatura_pkey (OID = 16423) : 
--
ALTER TABLE ONLY fatura
    ADD CONSTRAINT fatura_pkey PRIMARY KEY (id);
