package com.site.agencia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.site.agencia.entities.Destino;
import com.site.agencia.repositorys.DestinoRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/destinos")
public class DestinoController {
	
	@Autowired
	private DestinoRepository destinoRepository;
	
	// GET
	@GetMapping
	public ResponseEntity<List<Destino>> findAll() {
		
		List<Destino> destinos = destinoRepository.findAll();
		
		return ResponseEntity.ok().body(destinos);
	}
	
	// GET por id
	@GetMapping(value = "/{id}")
	public ResponseEntity<Destino> findById(@PathVariable Long id) {
		
		Destino destino = destinoRepository.findById(id).get();
		
		return ResponseEntity.ok().body(destino);
	}
	
	// CREATE
    @PostMapping
    public Destino create(@RequestBody Destino destino) {
    	
        return destinoRepository.save(destino);
    }
    
    // UPDATE
    @PutMapping("{id}")
    public ResponseEntity<Destino> update(@PathVariable long id,@RequestBody Destino destinoDetails) {
    	Destino updateDestino = destinoRepository.findById(id).get();

    	updateDestino.setNome(destinoDetails.getNome());
    	updateDestino.setUf(destinoDetails.getUf());

        destinoRepository.save(updateDestino);

        return ResponseEntity.ok(updateDestino);
    }

    // DELETE
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable long id) {

    	Destino autor = destinoRepository.findById(id).get();

    	destinoRepository.delete(autor);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
    
}
