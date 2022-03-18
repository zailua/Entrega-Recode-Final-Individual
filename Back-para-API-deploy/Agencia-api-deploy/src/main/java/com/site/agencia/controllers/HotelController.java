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

import com.site.agencia.entities.Hotel;
import com.site.agencia.repositorys.HotelRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/hoteis")
public class HotelController {
	
	@Autowired
	private HotelRepository hotelRepository;
	
	@GetMapping
	public ResponseEntity<List<Hotel>> findAll() {
		
		List<Hotel> hoteis = hotelRepository.findAll();
		
		return ResponseEntity.ok().body(hoteis);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Hotel> findById(@PathVariable Long id) {
		
		Hotel hotel = hotelRepository.findById(id).get();
		
		return ResponseEntity.ok().body(hotel);
	}
	
	// CREATE
    @PostMapping
    public Hotel createEmployee(@RequestBody Hotel Hotel) {
    	
        return hotelRepository.save(Hotel);
    }
    
    // UPDATE
    @PutMapping("{id}")
    public ResponseEntity<Hotel> update(@PathVariable long id,@RequestBody Hotel hotelDetails) {
    	Hotel updateHotel = hotelRepository.findById(id).get();

    	updateHotel.setNome(hotelDetails.getNome());

    	hotelRepository.save(updateHotel);

        return ResponseEntity.ok(updateHotel);
    }
    
    // DELETE
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable long id) {

    	Hotel hotel = hotelRepository.findById(id).get();

    	hotelRepository.delete(hotel);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
