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

import br.com.help.beans.DisponibilizarServico;
import br.com.help.services.DisponibilizarServService;
import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping("/dspServico")
public class DisponibilizarServController {

	@Autowired
	private DisponibilizarServService dspServicoService;

	@GetMapping(path = "/{id}")
	public ResponseEntity<DisponibilizarServico> find(@PathVariable Long id) {
		DisponibilizarServico dspServico = null;
		try {
			dspServico = dspServicoService.buscarPorId(id);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.ok(dspServico);
	}

	@PostMapping
	public ResponseEntity<DisponibilizarServico> insert(@Valid @RequestBody DisponibilizarServico dspServico)
			throws ObjectNotFoundException {
		dspServico = dspServicoService.inserir(dspServico);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("(id").buildAndExpand(dspServico.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<DisponibilizarServico> atualizar(@RequestBody DisponibilizarServico dspServico,
			@PathVariable Long id) {
		if (dspServico != null) {
			dspServico.setId(id);
			dspServicoService.atualizar(dspServico);
		}
		return ResponseEntity.ok().build();
	}

	@GetMapping
	public List todos() {
		return dspServicoService.buscarTodos();
	}
}
