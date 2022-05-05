INSERT INTO tb_desejo (status,titulo) VALUES (0, 'filmes de acao1');
INSERT INTO tb_desejo (status,titulo) VALUES (0, 'filmes de acao3');
INSERT INTO tb_desejo (status,titulo) VALUES (0, 'filmes de acao2');


INSERT INTO tb_filme (id_filme, titulo, ano_lancamento, liberado, genero, diretor, escritor, atores, enredo, lingua, pais, premios, image_cartaz, tipo, producao)
VALUES 
('tt01','wagner','wagner','wagner','wagner','wagner','wagner','wagner','wagner','wagner','wagner','wagner','wagner','wagner','wagner');

INSERT INTO tb_filme (id_filme, titulo, ano_lancamento, liberado, genero, diretor, escritor, atores, enredo, lingua, pais, premios, image_cartaz, tipo, producao)
VALUES 
('tt02','wagner','wagner','wagner','wagner','wagner','wagner','wagner','wagner','wagner','wagner','wagner','wagner','wagner','wagner');
 
 
 
INSERT INTO tb_desejo_filme (desejo_id, filme_id) VALUES (1 , 'tt01');
INSERT INTO tb_desejo_filme (desejo_id, filme_id) VALUES (1 , 'tt02');
 

INSERT INTO tb_comentario (descricao) VALUES ('filmes legal');
INSERT INTO tb_comentario (descricao) VALUES ('filmes show'); 
 
INSERT INTO tb_filme_comentario (filme_id,comentario_id) VALUES ('tt01',1);
INSERT INTO tb_filme_comentario (filme_id,comentario_id) VALUES ('tt02',2);

INSERT INTO tb_avaliacao (avaliacao) VALUES (5);
INSERT INTO tb_avaliacao (avaliacao) VALUES (2);
 
INSERT INTO tb_filme_avaliacao (filme_id,avaliacao_id) VALUES ('tt01',1);
INSERT INTO tb_filme_avaliacao (filme_id,avaliacao_id) VALUES ('tt02',2);
 