package br.com.help.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.help.beans.Solicitante;
import br.com.help.repository.SolicitanteRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class SolicitanteServiceImpl implements SolicitanteIService {

	@Autowired
	private SolicitanteRepository solicitanteRepo;

	@Override
	public Solicitante inserir(Solicitante entity) throws ObjectNotFoundException {
		if (entity == null) {
			throw new ObjectNotFoundException("O Solicitante não pode ser nulo");
		}
		return solicitanteRepo.save(entity);
	}

	@Override
	public Solicitante atualizar(Solicitante entity) {
		try {
			Solicitante solicitante = buscarPorId(entity.getId());
			if (solicitante != null) {
				return solicitanteRepo.save(entity);
			}
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Solicitante buscarPorId(Long id) throws IllegalAccessException {
		if (id <= 0) {
			throw new IllegalAccessError("O id não pode ser nulo");
		}
		Optional<Solicitante> solicitante = solicitanteRepo.findById(id);
		return solicitante.orElseThrow(() -> new IllegalAccessException("Solicitante não encontrado"));
	}

	@Override
	public void deletarPorId(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Solicitante> buscarTodos() {
		List<Solicitante> solicitantes = solicitanteRepo.findAll();
		if(!solicitantes.isEmpty()) {
			return solicitantes;
		}
		return null;
	}

}
