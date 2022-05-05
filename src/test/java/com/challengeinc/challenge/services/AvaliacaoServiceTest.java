package com.challengeinc.challenge.services;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.challengeinc.challenge.rn.RNGeralDoProjeto;
import com.challengeinc.challenge.services.exceptions.ExcecaoAvaliacaoRN;
import com.challengeinc.challenge.services.exceptions.ExcecaoDadosNaoEncontrado;

@SpringBootTest
public class AvaliacaoServiceTest {

	@Autowired
	RNGeralDoProjeto regraNegocio;

	@Test
	@DisplayName("Avalição não pode ser maior que 10 ou menor que 5")
	void avaliacaoNaoPodeSerMaiorQue10ouMenorQue5() {
		Long avaliacao = (long) 11;

		assertThrows(ExcecaoAvaliacaoRN.class, 
				() -> regraNegocio.avaliacaoNaoPodeSerMaiorQue10ouMenorQue5(avaliacao));

	}

	@Test
	@DisplayName("Verifica se um uma avalição existe para fazer Update / Delete")
	void verificarSeAvaliacaoExiste() {
		Long idAvaliacao = (long) 110;

		assertThrows(ExcecaoDadosNaoEncontrado.class,
				() -> regraNegocio.verificarExistenciaDeUmaAvaliacao(idAvaliacao));

	}

}
