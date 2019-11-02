package br.com.help.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.help.beans.Profissional;
import br.com.help.repository.ProfissionalRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ProfissionalServiceImpl implements ProfissionalService {

	@Autowired
	ProfissionalRepository profissionalRepo;

	@Override
	public Profissional inserir(Profissional profissional) {
		if (profissional == null) {
			throw new IllegalArgumentException("O Profissional não pode ser nulo");
		} else

			return profissionalRepo.save(profissional);

	}	

	@Override
	public Profissional atualizar(Profissional profissional) {
		if (profissional.getId() <= 0) {
			throw new IllegalArgumentException("O Profissional não pode ser nulo");
		}
		return profissionalRepo.save(profissional);
	}

	@Override
	public Profissional buscarPorId(Long id) throws IllegalAccessException {
		if (id <= 0) {
			throw new IllegalArgumentException("o id não pode ser nulo ou <= 0");
		}
		Optional<Profissional> profissional = profissionalRepo.findById(id);
		return profissional.orElseThrow(() -> new IllegalAccessException("o id não foi encontrado"));
	}

	@Override
	public void deletarPorId(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Profissional> buscarTodos() {
		List<Profissional> profissionais = profissionalRepo.findAll();
		if (!profissionais.isEmpty()) {
			return profissionais;
		}
		return null;
	}

	public Profissional find(Long id) throws ObjectNotFoundException {
		Optional<Profissional> prof = profissionalRepo.findById(id);
		return prof.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado ID: " + id + ", Tipo" + Profissional.class.getName()));
	}

}
