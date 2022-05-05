package com.challengeinc.challenge.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.challengeinc.challenge.models.Avaliacao;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {
	@Modifying
	@Query(value = "DELETE From TB_FILME_AVALIACAO WHERE AVALIACAO_ID = :avaliacao_id ", nativeQuery = true)
	@Transactional
	void deleteAvaliacaoTBmovieAvaliacao(@Param("avaliacao_id") Long avaliacao_id);

	@Modifying
	@Query(value = "INSERT into TB_FILME_AVALIACAO (filme_id,avaliacao_id) VALUES (:filme_id,:avaliacao)", nativeQuery  = true)
	@Transactional
	void insertTBMovieAvaliacao(@Param("filme_id") String filme_id, @Param("avaliacao") Long avaliacao);

}
