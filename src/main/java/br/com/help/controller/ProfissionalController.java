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

import br.com.help.beans.Profissional;
import br.com.help.services.ProfissionalService;
import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping("/profissional")
public class ProfissionalController {

	@Autowired
	private ProfissionalService profService;

	@GetMapping(path = "/{id}")
	public ResponseEntity<Profissional> find(@PathVariable Long id) {
		Profissional objProfissional = null;
		try {
			objProfissional = profService.buscarPorId(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ResponseEntity.ok(objProfissional);

	}

	@PostMapping
	public ResponseEntity<Profissional> insert(@Valid @RequestBody Profissional obj) {
		try {
			obj = profService.inserir(obj);
		} catch (ObjectNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("(id)").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();

	}

	@GetMapping
	public List todos() {
		return profService.buscarTodos();
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<Profissional> atualizar(@RequestBody Profissional prof, @PathVariable Long id) {
		if(prof != null) {
			prof.setId(id);
			profService.atualizar(prof);	
		}

		return ResponseEntity.ok().build();
	}
}
