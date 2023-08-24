package edu.modelo;
/**
 * Esta clase se crea como base inicial para cada 
 * unidad de medida cada unidad de medida tiene 
 * un nombre y valor */
public abstract class ClaseBase {
	protected String nombre;
	protected double valor;
	
	public ClaseBase() {
		
	}
	public ClaseBase(String nombre, double valor) {
		this.nombre = nombre;
		this.valor = valor;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public double getValor() {
		return valor;
	}
}
