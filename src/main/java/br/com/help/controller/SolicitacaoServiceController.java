package br.com.help.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.help.beans.SolicitacaoServico;
import br.com.help.services.SolicitacaoIService;
import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping("/solicitacao")
public class SolicitacaoServiceController {

	@Autowired
	private SolicitacaoIService sServico;
	

	@GetMapping
	public List todos() {
		return sServico.buscarTodos();
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<SolicitacaoServico> porId(@PathVariable Long id) {
		SolicitacaoServico servico = null;
		try {
			servico = sServico.buscarPorId(id);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.ok(servico);
	}

	@PostMapping
	public ResponseEntity<SolicitacaoServico> inserir(@Valid @RequestBody SolicitacaoServico body) throws ObjectNotFoundException {
		body = sServico.inserir(body);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("id").buildAndExpand(body.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<SolicitacaoServico> atualizar(@RequestBody SolicitacaoServico servico,
			@PathVariable Long id) {
		if (servico != null) {
			servico.setId(id);
			sServico.atualizar(servico);
		}
		return ResponseEntity.ok().build();
	}
}
