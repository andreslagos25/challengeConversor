package edu.modelo;

import java.util.HashMap;
import java.util.Map;
//import edu.modelo.Pair;

public class ConversorMoneda {
	 private static final Map<Pair<String, String>, Double> tasasDeCambio = new HashMap<>();
	 static {
	        // Agregar tasas de cambio para diferentes combinaciones de divisas
	        tasasDeCambio.put(new Pair<>("USD", "EUR"), 0.85);
	        tasasDeCambio.put(new Pair<>("USD", "COP"), 3978.17);
	        tasasDeCambio.put(new Pair<>("USD", "YEN"), 110.0);
	        // Agregar más combinaciones de divisas si es necesario
	    }
	// No se como evitar la repeticion de codigo al validar la operacion para cambiar
	// de una divisa a otra
	// La unica idea es comparar cual de las dos divisas vale mas
	// Y hacer la comparacion respecto a su valor
	// Entonces en vez de comparar Strings comparo doubles
	// Tocaría hacer scrapping para sacar esos valores
	public double convertir(String divisaInicial, String divisaDestino, double cantidad) {
		Pair<String, String> claveTasa = new Pair<>(divisaInicial, divisaDestino);
		Double tasaDeCambio = tasasDeCambio.get(claveTasa);
		if(tasaDeCambio == null) {
			tasaDeCambio = 1.0;
		}
		
		return cantidad*tasaDeCambio;
	}
	
}
