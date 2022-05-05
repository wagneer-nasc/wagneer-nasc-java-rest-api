package com.challengeinc.challenge.rn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challengeinc.challenge.dto.AvaliacaoDTO;
import com.challengeinc.challenge.models.Comentario;
import com.challengeinc.challenge.repositories.AvaliacaoRepository;
import com.challengeinc.challenge.repositories.ComentarioRepository;
import com.challengeinc.challenge.repositories.EstrelaRepository;
import com.challengeinc.challenge.repositories.FilmeRepository;
import com.challengeinc.challenge.services.exceptions.ExcecaoAvaliacaoRN;
import com.challengeinc.challenge.services.exceptions.ExcecaoComentarioDuplicado;
import com.challengeinc.challenge.services.exceptions.ExcecaoDadosNaoEncontrado;

@Service
public class RNGeralDoProjeto {
	@Autowired
	private AvaliacaoRepository avaliacaoRepository;

	@Autowired
	private FilmeRepository filmeRepository;

	@Autowired
	private ComentarioRepository comentarioRepository;

	@Autowired
	private EstrelaRepository estrelaRepository;

	/**
	 * 
	 * @param dto
	 */
	public void avaliacaoNaoPodeSerMaiorQue10ouMenorQue5(Long avaliacao) {
		if (avaliacao > 10 || avaliacao < 5) {
			throw new ExcecaoAvaliacaoRN("Avalição não pode ser maior que 10 ou menor que 5.");
		}
	}

	/**
	 * 
	 * @param idFilme
	 */
	public void verificarExistenciaDeUmFilme(String idFilme) {
		boolean existe = filmeRepository.existsById(idFilme);
		if (!existe) {
			throw new ExcecaoDadosNaoEncontrado("Filme não encontrado, verifique o id do filme.");
		}
	}

	/**
	 * 
	 * @param id
	 */
	public void verificarExistenciaDeUmaAvaliacao(Long id) {
		boolean existe = avaliacaoRepository.existsById(id);
		if (!existe) {
			throw new ExcecaoDadosNaoEncontrado("avaliacao não encontrado, verifique o id da avaliacao.");
		}
	}

	/**
	 * 
	 * @param dto
	 */
	public void verificarExistenciaDeUmaAvaliacao(AvaliacaoDTO dto) {
		boolean existe = avaliacaoRepository.existsById(dto.getId());
		if (!existe) {
			throw new ExcecaoDadosNaoEncontrado("avaliacao não encontrado, verifique o id da avaliacao.");
		}
	}

	/**
	 * 
	 * @param descricaoComentario
	 * @param idFilme
	 */
	public void verificarDuplicidadeDeComentario(String descricaoComentario, String idFilme) {
		Comentario comentarioDuplicado = comentarioRepository.verificarDuplicidadeDeComentario(descricaoComentario,
				idFilme);

		if (comentarioDuplicado != null) {
			throw new ExcecaoComentarioDuplicado("Este Comentário voce já fez para este filme.");
		}
	}

	/**
	 * 
	 * @param id
	 */
	public void verificarExistenciaDeUmComentario(Long id) {
		boolean existe = comentarioRepository.existsById(id);

		if (!existe) {
			throw new ExcecaoDadosNaoEncontrado("Comentario não encontrado, verifique o id do comentario.");
		}
	}

	/**
	 * 
	 * @param estrela
	 */
	public void estrelaNaoPodeSerMaiorQue5ouMenorQue1(Long estrela) {
		if (estrela > 5 || estrela < 1) {
			throw new ExcecaoAvaliacaoRN("Estrela não pode ser maior que 5 ou menor que 1");
		}
	}

	/**
	 * 
	 * @param id
	 */
	public void verificarExistenciaDeUmaEstrela(Long id) {
		boolean existe = estrelaRepository.existsById(id);
		if (!existe) {
			throw new ExcecaoDadosNaoEncontrado("estrela não encontrado, verifique o id da estrela.");
		}
	}

}
