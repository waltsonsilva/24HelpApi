package br.com.help.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.help.beans.Profissional;

public interface ProfissionalRepository extends JpaRepository<Profissional, Integer> {

}
