package edu.test;

import edu.modelo.Divisa;


public class TestDivisa {
	public static void main(String[] args) {
		
		Divisa divisa = new Divisa();
		
		//double valorNuevo = divisa.convertir("EUR", "USD", 500);
		//System.out.println(valorNuevo);
		divisa.mostrarHashMap();
		System.out.println("Antes de actualizar");
		divisa.actualizarValores();
		divisa.mostrarHashMap();
		System.out.println("Despues de actualizar");
		
	}
}
