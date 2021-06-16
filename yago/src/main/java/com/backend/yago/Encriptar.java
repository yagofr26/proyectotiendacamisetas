package com.backend.yago;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Encriptar {

	public static void main(String[] args) {
		BCryptPasswordEncoder encriptador=new BCryptPasswordEncoder();
		System.out.println("contraseña encriptada es: "+encriptador.encode("hola"));

	}

}
