package com.challengeinc.challenge.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.challengeinc.challenge.models.Estrela;

@Repository
public interface EstrelaRepository extends JpaRepository<Estrela, Long> {
	@Modifying
	@Query(value = "DELETE From TB_FILME_ESTRELA WHERE ESTRELA_ID = :estrela_id ", nativeQuery = true)
	@Transactional
	void deleteTBFilmeEstrela(@Param("estrela_id") Long estrela_id);

	@Modifying
	@Query(value = "INSERT into TB_FILME_ESTRELA (filme_id,estrela_id) VALUES (:filme_id,:estrela_id)", nativeQuery = true)
	@Transactional
	void insertTBFilmeEstrela(@Param("filme_id") String filme_id, @Param("estrela_id") Long estrela_id);

}
