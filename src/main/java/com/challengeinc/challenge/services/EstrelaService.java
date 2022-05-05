package com.challengeinc.challenge.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.challengeinc.challenge.dto.EstrelaDTO;
import com.challengeinc.challenge.models.Estrela;
import com.challengeinc.challenge.repositories.EstrelaRepository;
import com.challengeinc.challenge.rn.RNGeralDoProjeto;

@Service
public class EstrelaService {

	@Autowired
	private EstrelaRepository estrelaRepository;

	@Autowired
	private RNGeralDoProjeto regraNegocio;

	@Transactional
	public EstrelaDTO insertEstrela(EstrelaDTO dto, String idFilme) {
		regraNegocio.verificarExistenciaDeUmFilme(idFilme);
		regraNegocio.estrelaNaoPodeSerMaiorQue5ouMenorQue1(dto.getEstrela());

		Estrela estrela = new Estrela();
		estrela.setEstrela(dto.getEstrela());
		estrelaRepository.save(estrela);
		insertTbFilmeEstrela(idFilme, estrela.getId());
		return new EstrelaDTO(estrela);

	}

	public void insertTbFilmeEstrela(String filme_id, long estrela_id) {
		estrelaRepository.insertTBFilmeEstrela(filme_id, (long) estrela_id);
	}

	public void deleteEstrela(Long idEstrela) {
		regraNegocio.verificarExistenciaDeUmaEstrela(idEstrela);
		estrelaRepository.deleteTBFilmeEstrela(idEstrela);
		estrelaRepository.deleteById(idEstrela);
	}

	@Transactional
	public EstrelaDTO updateEstrela(EstrelaDTO dto) {
		regraNegocio.verificarExistenciaDeUmaEstrela(dto.getId());
		regraNegocio.estrelaNaoPodeSerMaiorQue5ouMenorQue1(dto.getEstrela());

		Estrela estrela = new Estrela();
		estrela.setId(dto.getId());
		estrela.setEstrela(dto.getEstrela());
		estrelaRepository.save(estrela);
		return new EstrelaDTO(estrela);

	}

}
