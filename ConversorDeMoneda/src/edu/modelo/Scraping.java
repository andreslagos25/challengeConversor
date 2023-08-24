package edu.modelo;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Scraping {
	
	public static double obtenerTasaCambio(String divisaInicial, String divisaFinal) {
		try {
			Document doc = Jsoup.connect
					("https://www.google.com/finance/quote/"+divisaInicial+"-"+divisaFinal).get();
			String tasaCambioString = doc.getElementsByClass("YMlKec fxKbKc").text();
			tasaCambioString = tasaCambioString.replace(",", "");
			Double tasaCambio = Double.valueOf(tasaCambioString);
			return tasaCambio;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
}
