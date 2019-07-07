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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.help.beans.Profissional;
import br.com.help.services.ProfissionalService;

@RestController
@RequestMapping("/profissional")
public class ProfissionalController {

	@Autowired
	ProfissionalService profService;

	@GetMapping(path  = "/{id}")
	public ResponseEntity<Profissional> find(@PathVariable Integer id)  {
		Profissional objProfissional = null;
		try {
			objProfissional = profService.buscarPorId(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
			return ResponseEntity.ok(objProfissional);
		
	}

	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody Profissional obj) {
		obj = profService.inserir(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("(id)").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();

	}

	@GetMapping
	public List todos() {
		return profService.buscarTodos();
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<Profissional> atualizar(@RequestBody Profissional prof){
		if(prof != null) {
			profService.atualizar(prof);
		}
		return ResponseEntity.ok().build();
	}
}
