package br.com.help.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.help.beans.DisponibilizarServico;
import br.com.help.beans.Localizacao;
import br.com.help.beans.Profissional;
import br.com.help.repository.DisponibilizarServRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class DisponibilizarServServiceImpl implements DisponibilizarServService {

	@Autowired
	private DisponibilizarServRepository repo;

	@Autowired
	private ProfissionalService profService;

	@Override
	public DisponibilizarServico inserir(DisponibilizarServico entity) throws ObjectNotFoundException {
		if (entity == null) {
			throw new IllegalArgumentException("Não pode ser nulo");
		}
		entity.setFlagOnline(1);

		try {
			Profissional prof = profService.buscarPorId(entity.getProfissional().getId());
			entity.setProfissional(prof);
			Localizacao localizaocao = entity.getLocalizacao();
			if(localizaocao != null) {
				entity.setLocalizacao(localizaocao);
			}
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return repo.save(entity);
	}

	@Override
	public DisponibilizarServico atualizar(DisponibilizarServico entity) {
		if (entity.getId() <= 0) {
			throw new IllegalArgumentException("O id não pode ser menor ou igual a 0");
		}
		return repo.save(entity);
	}

	@Override
	public DisponibilizarServico buscarPorId(Long id) throws IllegalAccessException {
		if (id <= 0) {
			throw new IllegalArgumentException("O id não pode ser menor ou igual a zero ");
		}
		Optional<DisponibilizarServico> disponibilizarServico = repo.findById(id);
		return disponibilizarServico.orElseThrow(() -> new IllegalAccessException("Id não encontrado"));
	}

	@Override
	public void deletarPorId(Long id) {

	}

	@Override
	public List<DisponibilizarServico> buscarTodos() {
		List<DisponibilizarServico> listaDisponibilizarServicos = repo.findAll();
		if (!listaDisponibilizarServicos.isEmpty()) {
			return listaDisponibilizarServicos;
		}
		return null;
	}

}
