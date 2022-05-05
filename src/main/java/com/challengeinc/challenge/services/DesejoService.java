package com.challengeinc.challenge.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.challengeinc.challenge.dto.DesejoDTO;
import com.challengeinc.challenge.dto.FilmeDTO;
import com.challengeinc.challenge.models.Desejo;
import com.challengeinc.challenge.models.Filme;
import com.challengeinc.challenge.models.TemplateRetornoWs;
import com.challengeinc.challenge.repositories.DesejoRepository;
import com.challengeinc.challenge.repositories.FilmeRepository;
import com.challengeinc.challenge.services.exceptions.ExcecaoDadosNaoEncontrado;

@Service
public class DesejoService {

	@Autowired
	private DesejoRepository desejoRepository;

	@Autowired
	private FilmeRepository filmeRepository;

	@Autowired
	private WsServiceBuscarFilmes serviceGetMovie;

	@Transactional(readOnly = true)
	public List<DesejoDTO> findAll() {
		List<Desejo> listDesejo = desejoRepository.findAll();

		return listDesejo.stream().map(item -> new DesejoDTO(item)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public List<DesejoDTO> findOne(Long id) {
		Optional<Desejo> desejo = desejoRepository.findById((long) id);
		if (desejo.isEmpty()) {
			throw new ExcecaoDadosNaoEncontrado("Lista de desejo não encontrado , verificar o ID");
		}

		return desejo.stream().map(item -> new DesejoDTO(item)).collect(Collectors.toList());
	}

	@Transactional
	public DesejoDTO insert(DesejoDTO dto) {
		Desejo desejo = new Desejo();
		desejo.setStatus(dto.getStatus());
		desejo.setTitulo(dto.getTitulo());

		for (FilmeDTO movieDTO : dto.getFilmes()) {
			TemplateRetornoWs retornoWs = serviceGetMovie.buscarFilmePorId(movieDTO.getId_filme());
			Filme filme = adicionarNovoFilme(retornoWs);
			filmeRepository.save(filme);
			desejo.getFilmes().add(filme);
		}
		desejo = desejoRepository.save(desejo);
		return new DesejoDTO(desejo);
	}

	public Filme adicionarNovoFilme(TemplateRetornoWs retornoWs) {
		Filme filme = new Filme();
		filme.setAno_lancamento(retornoWs.getYear());
		filme.setAtores(retornoWs.getActors());
		filme.setDiretor(retornoWs.getDirector());
		filme.setEnredo(retornoWs.getPlot());
		filme.setEscritor(retornoWs.getWriter());
		filme.setGenero(retornoWs.getGenre());
		filme.setId_filme(retornoWs.getImdbID());
		filme.setImage_cartaz(retornoWs.getPoster());
		filme.setLiberado(retornoWs.getReleased());
		filme.setLingua(retornoWs.getLanguage());
		filme.setTitulo(retornoWs.getTitle());
		filme.setTipo(retornoWs.getType());
		filme.setProducao(retornoWs.getProduction());
		filme.setPremios(retornoWs.getAwards());
		filme.setPais(retornoWs.getCountry());
		return filme;
	}

}
