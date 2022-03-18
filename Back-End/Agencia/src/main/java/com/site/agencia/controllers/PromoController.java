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
import com.site.agencia.entities.Hotel;
import com.site.agencia.entities.Promocao;
import com.site.agencia.repositorys.DestinoRepository;
import com.site.agencia.repositorys.HotelRepository;
import com.site.agencia.repositorys.PromocaoRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/promocoes")
public class PromoController {
	
	@Autowired
	private PromocaoRepository promocaoRepository;
	
	@Autowired
	private DestinoRepository destinoRepository;
	
	@Autowired
	private HotelRepository hotelRepository;
	
	@GetMapping
	public ResponseEntity<List<Promocao>> findAll() {
		
		List<Promocao> promocoes = promocaoRepository.findAll();
		
		return ResponseEntity.ok().body(promocoes);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Promocao> findById(@PathVariable Long id) {
		
		Promocao promocao = promocaoRepository.findById(id).get();
		
		return ResponseEntity.ok().body(promocao);
	}
	
	// CREATE
    @PostMapping
    public Promocao createEmployee(@RequestBody Promocao promocao) {
    	
        return promocaoRepository.save(promocao);
    }
    
    // UPDATE
    @PutMapping("{id}")
    public ResponseEntity<Promocao> update(@PathVariable long id,@RequestBody Promocao promocaoDetails ) {
    	Promocao updatePromocao = promocaoRepository.findById(id).get();
    	Destino destino = destinoRepository.findById(promocaoDetails.getDestino().getId_destino()).get();
    	Hotel hotel = hotelRepository.findById(promocaoDetails.getHotel().getId()).get();

    	updatePromocao.setNome(promocaoDetails.getNome());
    	updatePromocao.setPreco(promocaoDetails.getPreco());
    	updatePromocao.setDestino(destino);
    	updatePromocao.setHotel(hotel);

    	promocaoRepository.save(updatePromocao);

        return ResponseEntity.ok(updatePromocao);
    }

    // DELETE
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable long id) {

    	Promocao destino = promocaoRepository.findById(id).get();

    	promocaoRepository.delete(destino);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
