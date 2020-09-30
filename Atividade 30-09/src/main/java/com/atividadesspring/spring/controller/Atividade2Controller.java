package com.atividadesspring.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/Teste2")

public class Atividade2Controller {
	@GetMapping
	public String atv () 
	{
		return "Os objetivos de aprendizagem para essa semana é aprender mais sobre o Spring e o Postman para eu poder ficar bem craque. :)";
		
	}
	
}
