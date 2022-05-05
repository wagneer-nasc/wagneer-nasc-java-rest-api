package com.challengeinc.challenge.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.challengeinc.challenge.dto.ComentarioDTO;
import com.challengeinc.challenge.models.Comentario;
import com.challengeinc.challenge.repositories.ComentarioRepository;
import com.challengeinc.challenge.rn.RNGeralDoProjeto;

@Service
public class ComentarioService {

	@Autowired
	private ComentarioRepository comentarioRepository;

	@Autowired
	private RNGeralDoProjeto regraNegocio;

	@Transactional
	public ComentarioDTO insertComentario(ComentarioDTO dto, String idFilme) {

		regraNegocio.verificarExistenciaDeUmFilme(idFilme);
		regraNegocio.verificarDuplicidadeDeComentario(dto.getDescricao(), idFilme);

		Comentario comentario = new Comentario();
		comentario.setDescricao(dto.getDescricao());
		comentarioRepository.save(comentario);
		insertTbMovieComentatio(idFilme, comentario.getId());
		return new ComentarioDTO(comentario);

	}

	public void insertTbMovieComentatio(String movie_id, long comentario_id) {
		comentarioRepository.insertTBMovieComentario(movie_id, (long) comentario_id);
	}

	public void deleteComentario(Long idComentario) {

		regraNegocio.verificarExistenciaDeUmComentario(idComentario);

		comentarioRepository.deleteComentarioTBmovieComentario(idComentario);
		comentarioRepository.deleteById(idComentario);
	}

	@Transactional
	public ComentarioDTO updateComentario(ComentarioDTO comentarioDTO) {
		regraNegocio.verificarExistenciaDeUmComentario(comentarioDTO.getId());

		Comentario comentario = new Comentario();
		comentario.setId(comentarioDTO.getId());
		comentario.setDescricao(comentarioDTO.getDescricao());
		comentarioRepository.save(comentario);
		return new ComentarioDTO(comentario);

	}

}
