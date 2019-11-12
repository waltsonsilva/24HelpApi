package br.com.help.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.help.beans.SolicitacaoServico;
import br.com.help.beans.Solicitante;
import br.com.help.repository.SolicitacaoRepository;
import javassist.tools.rmi.ObjectNotFoundException;

public class SolicitacaoServiceImpl implements SolicitacaoIService {

	@Autowired
	private SolicitacaoRepository solicitacaoRepo;

	@Autowired
	private SolicitanteIService solicitanteService;

	@Override
	public SolicitacaoServico inserir(SolicitacaoServico entity) throws ObjectNotFoundException {
		if (entity == null) {
			throw new IllegalArgumentException("Solicitação não pode ser nulo!");
		}
		try {
			Solicitante solicitante = solicitanteService.buscarPorId(entity.getSolicitante().getId());
			entity.setSolicitante(solicitante);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return solicitacaoRepo.save(entity);
	}

	@Override
	public SolicitacaoServico atualizar(SolicitacaoServico entity) {
		if (entity.getId() <= 0) {
			throw new IllegalArgumentException("O id não pode ser meno ou igual a zero!");
		}
		return solicitacaoRepo.save(entity);
	}

	@Override
	public SolicitacaoServico buscarPorId(Long id) throws IllegalAccessException {
		if (id <= 0) {
			throw new IllegalArgumentException("O id não pode ser meno ou igual a zero!");
		}
		Optional<SolicitacaoServico> solicitacaoServico = solicitacaoRepo.findById(id);
		return solicitacaoServico.orElseThrow(() -> new IllegalAccessError("Id não encontrado"));
	}

	@Override
	public void deletarPorId(Long id) {
		try {
			buscarPorId(id);
			solicitacaoRepo.deleteById(id);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<SolicitacaoServico> buscarTodos() {
		List<SolicitacaoServico> listaSolicitacao = solicitacaoRepo.findAll();
		if (!listaSolicitacao.isEmpty()) {
			return listaSolicitacao;
		}
		return null;
	}

}
