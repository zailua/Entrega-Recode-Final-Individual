package com.site.agencia;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.site.agencia.entities.Destino;
import com.site.agencia.entities.Hotel;
import com.site.agencia.entities.Promocao;
import com.site.agencia.repositorys.DestinoRepository;
import com.site.agencia.repositorys.HotelRepository;
import com.site.agencia.repositorys.PromocaoRepository;

@SpringBootApplication
public class AgenciaApplication implements CommandLineRunner {
	
	@Autowired
	private DestinoRepository autorRepository;
	
	@Autowired
	private HotelRepository hotelRepository;
	
	@Autowired
	private PromocaoRepository promocaoRepository;

	public static void main(String[] args) {
		SpringApplication.run(AgenciaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		
		
	}

}
