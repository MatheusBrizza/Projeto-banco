package com.banco.senac.projetobanco;

import com.banco.senac.projetobanco.telas.MenuInicial;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ProjetoBancoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoBancoApplication.class, args);
		MenuInicial menu = new MenuInicial();
		menu.imprimirMenuInicial();
	}


}
