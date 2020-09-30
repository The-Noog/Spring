package com.atividadesspring.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/Teste")

public class Atividade1Controller {
	@GetMapping
	public String atv () 
	{
		return "Meu prinmeiro hello word sozinho. Nessa atividade eu usei a habilidade de attenção aos detalhes e proatividade. E usei a mentalidade de crescimento aos detalhes e persistência.";
		
	}
	
}
