package br.com.help.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.help.beans.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Optional<Usuario> findById(Long id);

}
