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

import br.com.help.beans.Solicitante;
import br.com.help.services.SolicitanteIService;
import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping("/solicitante")
public class SolicitanteController {

	@Autowired
	private SolicitanteIService solicitanteService;

	@GetMapping
	public List todos(){
		return solicitanteService.buscarTodos();
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Solicitante> busca(@PathVariable Long id){
		Solicitante solicitante = null;
		try {
			solicitante = solicitanteService.buscarPorId(id);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.ok(solicitante);
	}
	
	@PostMapping
	public ResponseEntity<Solicitante> inserir(@Valid @RequestBody Solicitante obj){
		try {
			obj = solicitanteService.inserir(obj);
		} catch (ObjectNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("(id)").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();

	}
	@PutMapping(path = "/{id}")
	public ResponseEntity<Solicitante>atualizar(@RequestBody Solicitante obj, @PathVariable Long id){
	
		if(obj != null) {
			obj.setId(id);
			solicitanteService.atualizar(obj);
		}
			
			return ResponseEntity.ok().build();
		}
	
}
