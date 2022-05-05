package com.challengeinc.challenge.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.challengeinc.challenge.models.Comentario;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
	@Modifying
	@Query(value = "DELETE From TB_FILME_COMENTARIO WHERE COMENTARIO_ID = :comentario_id ", nativeQuery = true)
	@Transactional
	void deleteComentarioTBmovieComentario(@Param("comentario_id") Long comentario_id);

	@Modifying
	@Query(value = "INSERT into TB_FILME_COMENTARIO (filme_id,comentario_id) VALUES (:filme_id,:comentario_id)", nativeQuery = true)
	@Transactional
	void insertTBMovieComentario(@Param("filme_id") String filme_id, @Param("comentario_id") Long comentario_id);

	@Query(value = "SELECT descricao,id from TB_COMENTARIO as comentario "
			+ "inner join tb_filme_comentario as filme on comentario.id = filme.comentario_id "
			+ "where descricao = :descricao and filme_id = :filme_id", nativeQuery = true)
	Comentario verificarDuplicidadeDeComentario(@Param("descricao") String descricao,
			@Param("filme_id") String filme_id);

}
