package br.com.help.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.help.beans.SolicitacaoServico;
public interface SolicitacaoRepository extends JpaRepository<SolicitacaoServico, Long> {

}
