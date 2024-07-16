INSERT INTO usuario
(email, nome, password)
VALUES('usuario_um@usuario.com.br', 'Usuario Um', '$2a$10$tN3Y2CnZmmI/uw.1Mu/ZaOP2ToUa1O0mK0wzvAvgXD.kW5BHrnPge');

INSERT INTO usuario
(email, nome, password)
VALUES('usuario_dois@usuario.com.br', 'Usuario Dois', '$2a$10$tN3Y2CnZmmI/uw.1Mu/ZaOP2ToUa1O0mK0wzvAvgXD.kW5BHrnPge');

INSERT INTO perfil
(nome)
VALUES('Usuario Um');

INSERT INTO perfil
(nome)
VALUES('Usuario Dois');

INSERT INTO usuario_perfis
(usuarios_id, perfis_id)
VALUES((SELECT id FROM usuario WHERE email = 'usuario_dois@usuario.com.br'), (SELECT id FROM perfil WHERE nome = 'Usuario Dois'));

INSERT INTO usuario_perfis
(usuarios_id, perfis_id)
VALUES((SELECT id FROM usuario WHERE email = 'usuario_um@usuario.com.br'), (SELECT id FROM perfil WHERE nome = 'Usuario Um'));

INSERT INTO curso
(categoria, nome)
VALUES('Exatas', 'Matemática');

INSERT INTO curso
(categoria, nome)
VALUES('Humanas', 'Artes');