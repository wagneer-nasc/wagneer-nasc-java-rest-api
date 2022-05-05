package com.challengeinc.challenge.services;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.challengeinc.challenge.rn.RNGeralDoProjeto;
import com.challengeinc.challenge.services.exceptions.ExcecaoComentarioDuplicado;
import com.challengeinc.challenge.services.exceptions.ExcecaoDadosNaoEncontrado;

@SpringBootTest
class ComentarioServiceTest {

	@Autowired
	RNGeralDoProjeto regraNegocio;

	@Test
	@DisplayName("Verifica se um comentário já existe naquele filme")
	void verificarSecomentarioJaExisteEvitarDuplicidade() {
		String idFilme = "tt0462499";
		String comentario = "muito bacana esse filme";

		assertThrows(ExcecaoComentarioDuplicado.class,
				() -> regraNegocio.verificarDuplicidadeDeComentario(comentario, idFilme));

	}

	@Test
	@DisplayName("Verifica se um comentário já existe para fazer Update / Delete")
	void verificarSecomentarioJaExiste() {
		Long idComentario = (long) 110;

		assertThrows(ExcecaoDadosNaoEncontrado.class,
				() -> regraNegocio.verificarExistenciaDeUmComentario(idComentario));

	}
}
