package br.com.help.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.help.beans.Profissional;

public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {
	
	Optional<Profissional> findById(Long id);

}
