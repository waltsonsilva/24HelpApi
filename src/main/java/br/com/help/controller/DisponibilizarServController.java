package br.com.help.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.help.beans.DisponibilizarServico;
import br.com.help.services.DisponibilizarServServiceImpl;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("/dspServico")
public class DisponibilizarServController {

	@Autowired
	private DisponibilizarServServiceImpl dspServicoService;
	
	@GetMapping(path ="/{id}")
	public ResponseEntity<DisponibilizarServico> find(@PathVariable Long id){
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
	public ResponseEntity<Void>insert(@Valid @RequestBody DisponibilizarServico dspServico) throws ObjectNotFoundException{
		dspServico = dspServicoService.inserir(dspServico);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("(id").buildAndExpand(dspServico.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
}
