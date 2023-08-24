package edu.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import edu.modelo.ConversorMoneda;
import java.text.DecimalFormat;
import edu.modelo.*;
public class testScrapping {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		try {
			
			/*Document doc = Jsoup.connect("https://www.google.com/finance/quote/EUR-USD?hl=es").get();
			String tasaCambio = doc.getElementsByClass("YMlKec fxKbKc").text();
			tasaCambio = tasaCambio.replace(",", ".");
			Double tasaDeCambio = Double.valueOf(tasaCambio);
			ConversorMoneda conversor = new ConversorMoneda();
			double divisaFinal = conversor.convertir("USD", "COP", 500);
			DecimalFormat decimalFormat = new DecimalFormat("#.##");
			decimalFormat.setMaximumFractionDigits(2);
			String valorFormatedo = decimalFormat.format(divisaFinal);
			System.out.println("El valor de 500 euros a dolares es: " + valorFormatedo);*/
			double nuevaTasaCambio = Scraping.obtenerTasaCambio("USD", "EUR");
			
		} catch (Exception e) {
			System.out.println("No se pudo obtener la web\n" + e);
		}
		
		
		
	}
	
	private static void log(String msg, String... vals) {
        System.out.println(String.format(msg, vals));
    }
}
