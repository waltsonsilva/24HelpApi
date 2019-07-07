package br.com.help.repository;

import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.help.beans.DisponibilizarServico;

public interface DisponibilizarServRepository extends JpaRepository<DisponibilizarServico, Integer> {

}
