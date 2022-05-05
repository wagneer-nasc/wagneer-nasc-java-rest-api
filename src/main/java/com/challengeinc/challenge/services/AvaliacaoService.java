package com.challengeinc.challenge.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.challengeinc.challenge.dto.AvaliacaoDTO;
import com.challengeinc.challenge.models.Avaliacao;
import com.challengeinc.challenge.repositories.AvaliacaoRepository;
import com.challengeinc.challenge.rn.RNGeralDoProjeto;

@Service
public class AvaliacaoService {

	@Autowired
	private AvaliacaoRepository avaliacaoRepository;

	@Autowired
	private RNGeralDoProjeto regraNegocio;

	@Transactional
	public AvaliacaoDTO insertAvaliacao(AvaliacaoDTO dto, String idFilme) {

		regraNegocio.verificarExistenciaDeUmFilme(idFilme);
		regraNegocio.avaliacaoNaoPodeSerMaiorQue10ouMenorQue5(dto.getAvaliacao());

		Avaliacao avaliacao = new Avaliacao();
		avaliacao.setAvaliacao(dto.getAvaliacao());

		avaliacaoRepository.save(avaliacao);
		insertTbMovieAvaliacao(idFilme, avaliacao.getId());
		return new AvaliacaoDTO(avaliacao);

	}

	public void insertTbMovieAvaliacao(String movie_id, long comentario_id) {
		avaliacaoRepository.insertTBMovieAvaliacao(movie_id, (long) comentario_id);
	}

	public void deleteAvaliacao(Long avaliacao_id) {

		regraNegocio.verificarExistenciaDeUmaAvaliacao(avaliacao_id);

		avaliacaoRepository.deleteAvaliacaoTBmovieAvaliacao(avaliacao_id);
		avaliacaoRepository.deleteById(avaliacao_id);
	}

	@Transactional
	public AvaliacaoDTO updateAvaliacao(AvaliacaoDTO dto) {
		regraNegocio.verificarExistenciaDeUmaAvaliacao(dto);
		regraNegocio.avaliacaoNaoPodeSerMaiorQue10ouMenorQue5(dto.getAvaliacao());

		Avaliacao avaliacao = new Avaliacao();
		avaliacao.setId(dto.getId());
		avaliacao.setAvaliacao(dto.getAvaliacao());
		avaliacaoRepository.save(avaliacao);
		return new AvaliacaoDTO(avaliacao);

	}

}
