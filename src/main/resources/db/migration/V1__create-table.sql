CREATE TABLE curso (
  id bigint NOT NULL AUTO_INCREMENT,
  categoria varchar(255) DEFAULT NULL,
  nome varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE perfil (
  id bigint NOT NULL AUTO_INCREMENT,
  nome varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE usuario (
  id bigint NOT NULL AUTO_INCREMENT,
  email varchar(255) DEFAULT NULL,
  nome varchar(255) DEFAULT NULL,
  password varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE usuario_perfis (
  usuarios_id bigint NOT NULL,
  perfis_id bigint NOT NULL,
  KEY FK7bhs80brgvo80vhme3u8m6ive (perfis_id),
  KEY FK7jhsqvsev9kka23ll2134ub95 (usuarios_id),
  CONSTRAINT FK7bhs80brgvo80vhme3u8m6ive FOREIGN KEY (perfis_id) REFERENCES perfil (id),
  CONSTRAINT FK7jhsqvsev9kka23ll2134ub95 FOREIGN KEY (usuarios_id) REFERENCES usuario (id)
);

CREATE TABLE topico (
  id bigint NOT NULL AUTO_INCREMENT,
  data_criacao datetime(6) DEFAULT NULL,
  mensagem text NOT NULL,
  status bit(1) NOT NULL,
  titulo varchar(255) NOT NULL,
  autor_id bigint NOT NULL,
  curso_id bigint NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY UKf1fx5u7uj9ma3w8flkn3h683m (titulo),
  KEY FKsk04hscorwqdymnafg8882v64 (autor_id),
  KEY FKcaaogjo0ynd54updie6kdpxd1 (curso_id),
  CONSTRAINT FKcaaogjo0ynd54updie6kdpxd1 FOREIGN KEY (curso_id) REFERENCES curso (id),
  CONSTRAINT FKsk04hscorwqdymnafg8882v64 FOREIGN KEY (autor_id) REFERENCES usuario (id)
);

CREATE TABLE resposta (
  id bigint NOT NULL AUTO_INCREMENT,
  data_criacao datetime(6) DEFAULT NULL,
  mensagem text,
  solucao text,
  autor_id bigint DEFAULT NULL,
  topico_id bigint DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FK9999kvnmdq63ah7imctrl06r7 (autor_id),
  KEY FKltuv9rkfjtlmn8b0rb3wdbjsv (topico_id),
  CONSTRAINT FK9999kvnmdq63ah7imctrl06r7 FOREIGN KEY (autor_id) REFERENCES usuario (id),
  CONSTRAINT FKltuv9rkfjtlmn8b0rb3wdbjsv FOREIGN KEY (topico_id) REFERENCES topico (id)
);