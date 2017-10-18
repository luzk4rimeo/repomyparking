package com.ceiba.databuilder;

import com.ceiba.model.Vehiculo;


public class VehiculoTestDataBuilder {

	private static final Integer CILINDRAJE = 1250;
	private static final String MARCA = "KIA";
	private static final String COLOR = "AZUL";
	private static final String PLACA = "ABC123";
	
	private String marca;
	private String color;
	private String placa;
	private Integer cilindraje;
	
	
	/**
	 * @param marca
	 * @param color
	 * @param placa
	 * @param cilindraje
	 */
	public VehiculoTestDataBuilder() {
		this.marca = MARCA;
		this.color = COLOR;
		this.placa = PLACA;
		this.cilindraje = CILINDRAJE;
	}
	
	public VehiculoTestDataBuilder conMarca(String marca) {
		this.marca = marca;
		return this;
	}
	
	public VehiculoTestDataBuilder conPlaca(String placa) {
		this.placa = placa;
		return this;
	}
	public VehiculoTestDataBuilder conColor(String color) {
		this.color = color;
		return this;
	}
	public VehiculoTestDataBuilder conCilindraje(Integer cilindraje) {
		this.cilindraje = cilindraje;
		return this;
	}
	
	public Vehiculo build() {
		return new Vehiculo(this.marca, this.color, this.placa,this.cilindraje);
	}
	
	
	
}
