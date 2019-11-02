package br.com.help.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.help.beans.Solicitante;

public interface SolicitanteRepository extends JpaRepository<Solicitante, Long>{
	
	Optional<Solicitante> findById(Long id);

}
