package edu.modelo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Map;
import edu.modelo.Divisa;
public class Interfaz extends JFrame implements ItemListener, ActionListener{
	private JComboBox<String> combo1;
	private JLabel enunciado1, enunciado2, labelDivisa1, labelDivisa2;
	private JTextField divisaInicial, divisaFinal;
	private JButton botonSalir, botonConvertir;
	public Interfaz(){
		setLayout(null);
		enunciado1 = new JLabel("Selecciona la divisa a ");
		enunciado2 = new JLabel("la cual quieres convertir");
		divisaInicial = new JTextField("", 15);
		divisaFinal = new JTextField("", 15);
		divisaFinal.setEditable(false);
		labelDivisa1 = new JLabel("Ingresa el valor a convertir");
		labelDivisa2 = new JLabel("Valor final");
		botonSalir = new JButton("Finalizar");
		botonConvertir = new JButton("Convertir");
		divisaInicial.setBounds(30,180,250, 30);
		divisaFinal.setBounds(30,280, 250, 30);
		botonSalir.setBounds(30, 400, 100, 30);
		botonConvertir.setBounds(200, 400, 100, 30);
		enunciado1.setBounds(10, 15, 250, 40);
		enunciado2.setBounds(135, 15, 250, 40);
		labelDivisa1.setBounds(30,150,250,40);
		labelDivisa2.setBounds(30,250,250,40);
		add(botonSalir);
		add(botonConvertir);
		add(labelDivisa1);
		add(labelDivisa2);
		add(enunciado1);
		add(enunciado2);
		add(divisaInicial);
		add(divisaFinal);
		combo1 = new JComboBox<String>();
		combo1.setBounds(30, 70, 100, 20);
		add(combo1);
		for(Map.Entry<Pair<String, String>, Double> entry : Divisa.getTasaCambio().entrySet()) {
			Pair<String, String> key = entry.getKey();
			combo1.addItem(key.getKey() + " - " + key.getValue());
			combo1.addItem(key.getValue() + " - " + key.getKey());
		}
		combo1.addItemListener(this);
		botonSalir.addActionListener(this);
		botonConvertir.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botonSalir) {
			 System.exit(0);
		}
		if(e.getSource() == botonConvertir) {
			String SDivisaInicial = combo1.getSelectedItem().toString().substring(0, 3);
			String SDivisaFinal = combo1.getSelectedItem().toString().substring(6, 9);
			Double valorDivisa = Divisa.convertir(SDivisaInicial, SDivisaFinal, Double.valueOf(divisaInicial.getText()));
			divisaFinal.setText(valorDivisa.toString());
			
		}
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == combo1) {
			String seleccionado = (String) combo1.getSelectedItem();
			setTitle(seleccionado);
		}
	}
	
	public static void main(String[] args) {
		Interfaz interfaz = new Interfaz();
		interfaz.setBounds(500,160,350,500);
		interfaz.setVisible(true);
		interfaz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
		
}

