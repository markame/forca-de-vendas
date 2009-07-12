-- SQL Manager 2007 Lite for PostgreSQL 4.5.0.8
-- ---------------------------------------
-- Host      : localhost
-- Database  : clienteEJB
-- Version   : PostgreSQL 8.3.3, compiled by Visual C++ build 1400



CREATE SCHEMA cliente_schema AUTHORIZATION cliente;
--
-- Definition for language plpgsql (OID = 16386) : 
--
CREATE TRUSTED PROCEDURAL LANGUAGE plpgsql
   HANDLER "plpgsql_call_handler"
   VALIDATOR "pg_catalog"."plpgsql_validator";
SET check_function_bodies = false;
--
-- Structure for table cliente_table (OID = 20204) : 
--
SET search_path = cliente_schema, pg_catalog;
CREATE TABLE cliente_schema.cliente_table (
    id integer DEFAULT nextval(('"cliente_schema"."cliente_sequence"'::text)::regclass) NOT NULL,
    nome character varying(30) NOT NULL,
    endereco character varying(30) NOT NULL,
    cpf character varying(30) NOT NULL,
    telefone character varying(30) NOT NULL
) WITH OIDS;
--
-- Definition for sequence cliente_sequence (OID = 20209) : 
--
CREATE SEQUENCE cliente_schema.cliente_sequence
    INCREMENT BY 1
    MAXVALUE 2147483647
    NO MINVALUE
    CACHE 1;
--
-- Definition for index cliente_table_pkey (OID = 20207) : 
--
ALTER TABLE ONLY cliente_table
    ADD CONSTRAINT cliente_table_pkey PRIMARY KEY (id);
