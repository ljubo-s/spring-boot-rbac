--DROP DATABASE db_rbac;
/*
DROP TABLE permission_users;
DROP TABLE permission_role;
DROP TABLE users_role;
DROP TABLE permission;
DROP TABLE users;
DROP TABLE role;
*/
--CREATE DATABASE db_rbac WITH OWNER = postgres ENCODING = 'UTF8' template=template0;

CREATE TABLE permission
(
  id serial NOT NULL,
  title character varying(50) NOT NULL,
  module character varying(150) NOT NULL,
  key character varying(50) NOT NULL,
  CONSTRAINT permission_pkey PRIMARY KEY (id)
);

CREATE TABLE users
(
  id serial NOT NULL,
  username character varying(50) NOT NULL,
  password character varying(50) NOT NULL,
  dateofinsert timestamp without time zone,
  lastupdate timestamp without time zone,
  status integer,
  CONSTRAINT users_pkey PRIMARY KEY (id)
);

CREATE TABLE role
(
  id serial NOT NULL,
  title character varying(50),
  description character varying(150),
  status integer,
  CONSTRAINT role_pkey PRIMARY KEY (id)
);

CREATE TABLE permission_users
(
  id serial NOT NULL,
  users_id integer, 
  permission_id integer,		
  description character varying,
  status integer,
  CONSTRAINT permission_users_pkey PRIMARY KEY (id),
  CONSTRAINT permission_users_users_id_fkey FOREIGN KEY (users_id)
      REFERENCES users (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION, 
  CONSTRAINT permission_users_permission_id_fkey FOREIGN KEY (permission_id)
      REFERENCES permission (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION  
);

CREATE TABLE users_role
(
  id serial NOT NULL,
  users_id integer, 
  role_id integer,		
  description character varying,
  status integer,
  CONSTRAINT users_role_pkey PRIMARY KEY (id),
  CONSTRAINT users_role_users_id_fkey FOREIGN KEY (users_id)
      REFERENCES users (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION, 
  CONSTRAINT users_role_role_id_fkey FOREIGN KEY (role_id)
      REFERENCES role (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION  
);

CREATE TABLE permission_role
(
  id serial NOT NULL,
  permission_id integer,
  role_id integer, 
  description character varying,
  status integer,
  CONSTRAINT permission_role_pkey PRIMARY KEY (id),
  CONSTRAINT permission_role_permission_id_fkey FOREIGN KEY (permission_id)
      REFERENCES permission (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION, 
  CONSTRAINT permission_role_role_id_fkey FOREIGN KEY (role_id)
      REFERENCES role (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION  
);
