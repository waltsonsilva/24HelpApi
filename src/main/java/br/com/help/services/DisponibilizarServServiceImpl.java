package br.com.help.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.help.beans.DisponibilizarServico;
import br.com.help.repository.DisponibilizarServRepository;

public class DisponibilizarServServiceImpl implements DisponibilizarServService{
	
	@Autowired
	private DisponibilizarServRepository repo;

	@Override
	public DisponibilizarServico inserir(DisponibilizarServico entity) {
		if(entity == null) {
			throw new IllegalArgumentException("Não pode ser nulo");
		}
		entity.setFlagOnline(1);
		return repo.save(entity);
	}

	@Override
	public DisponibilizarServico atualizar(DisponibilizarServico entity) {
		if(entity.getId()<= 0) {
			throw new IllegalArgumentException("O id não pode ser menor ou igual a 0");
		}
		return repo.save(entity);
	}

	@Override
	public DisponibilizarServico buscarPorId(int id) throws IllegalAccessException {
		if(id <=0 ) {
			throw new IllegalArgumentException("O id não pode ser menor ou igual a zero ");
		}
		Optional<DisponibilizarServico> disponibilizarServico = repo.findById(id);
		return disponibilizarServico.orElseThrow(()-> new IllegalAccessException("Id não encontrado"));
	}

	@Override
	public void deletarPorId(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<DisponibilizarServico> buscarTodos() {
		List<DisponibilizarServico> listaDisponibilizarServicos = repo.findAll();
		if(!listaDisponibilizarServicos.isEmpty()) {
			return listaDisponibilizarServicos;
		}
		return null;
	}

}
