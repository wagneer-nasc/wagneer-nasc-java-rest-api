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
class EstrelaServiceTest {

	@Autowired
	RNGeralDoProjeto regraNegocio;

	@Test
	@DisplayName("Verifica se um uma Estrela existe para fazer Update / Delete")
	void verificarSeEstrelaExiste() {
		Long idEstrela = (long) 110;

		assertThrows(ExcecaoDadosNaoEncontrado.class, 
				() -> regraNegocio.verificarExistenciaDeUmaEstrela(idEstrela));
	}

	@Test
	@DisplayName("Estrela nao pode ser maior que 5 ou menor que 1")
	void estrelaNaoPodeSerMaiorQue5ouMenorQue1() {
		Long estrela = (long) 6;

		assertThrows(ExcecaoAvaliacaoRN.class, 
				() -> regraNegocio.estrelaNaoPodeSerMaiorQue5ouMenorQue1(estrela));
	}

}
