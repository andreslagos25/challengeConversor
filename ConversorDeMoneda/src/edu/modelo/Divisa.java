package edu.modelo;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Esta clase Divisa extiende de ClaseBase
 * y adicionalmente tiene un signo que se le identifica */
public class Divisa{
	private static Map<Pair<String, String>, Double> tasaCambio = new HashMap<>();
	static{
		tasaCambio.put(new Pair<>("USD", "EUR"), 0.9059);
		tasaCambio.put(new Pair<>("USD", "COP"), 3976.46);
		tasaCambio.put(new Pair<>("USD", "GBP"), 0.78);
		tasaCambio.put(new Pair<>("COP", "MXN"), 0.0043);
		tasaCambio.put(new Pair<>("COP", "PEN"), 0.00090);
		tasaCambio.put(new Pair<>("COP", "CLP"), 0.21);
	}

	public static Map<Pair<String, String>, Double> getTasaCambio() {
		return tasaCambio;
	}
	public static String getDivisaInicial() {
		Map.Entry<Pair<String, String>, Double> entry = (Entry<Pair<String, String>, Double>) tasaCambio.entrySet();
			Pair<String, String> key = entry.getKey();
		
		return key.getKey();
	}
	public static String getDivisaFinal() {
		Map.Entry<Pair<String, String>, Double> entry = (Entry<Pair<String, String>, Double>) tasaCambio.entrySet();
			Pair<String, String> key = entry.getKey();
		
		return key.getValue();
	}
	public static void setTasaCambio(Map<Pair<String, String>, Double> tasaCambio) {
		Divisa.tasaCambio = tasaCambio;
	}
	// Esta funcion debe poder actualizar el valor
	// de la tasa de cambio en el Map.
	public void mostrarHashMap() {
		for (Map.Entry<Pair<String, String>, Double> entry : tasaCambio.entrySet()) {
			Pair<String, String> key = entry.getKey();
			Double value = entry.getValue();
			System.out.println(key.getKey() + " - " + key.getValue()+": "+ value);
		}
	}
	public void actualizarValores() {
		for(Map.Entry<Pair<String, String>, Double> entry : tasaCambio.entrySet()) {
			Pair<String, String> key = entry.getKey();
			Double value = Scraping.obtenerTasaCambio(key.getKey(), key.getValue());
			tasaCambio.put(new Pair<>(key.getKey(), key.getValue()), value);
			
		}
			
	}
	public static double convertir(String divisaInicial, String divisaFinal, double cantidad) {
		for (Map.Entry<Pair<String, String>, Double> entry : tasaCambio.entrySet()) {
			Pair<String, String> key = entry.getKey();
			Double value = entry.getValue();
			if(divisaInicial.equals(key.getKey())) {
				if(divisaFinal.equals(key.getValue())) {
					return value * cantidad;
				}
				//System.out.println("Este es el valor de la divisa inicial" + key);
			}else if(divisaFinal.equals(key.getKey())) {
				if(divisaInicial.equals(key.getValue()))
					return cantidad / value;
			}
		}
		return 0;
	}
	
}
