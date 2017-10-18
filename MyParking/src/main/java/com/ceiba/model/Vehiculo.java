/**
 * 
 */
package com.ceiba.model;

/**
 * @author luz.ocampo
 *
 */
public class Vehiculo {
	
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
	public Vehiculo(String marca, String color, String placa, Integer cilindraje) {
		this.marca = marca;
		this.color = color;
		this.placa = placa;
		this.cilindraje = cilindraje;
	}
	
	public Vehiculo() {}
	
	/**
	 * @return the marca
	 */
	public String getMarca() {
		return marca;
	}
	/**
	 * @param marca the marca to set
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}
	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}
	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}
	/**
	 * @return the placa
	 */
	public String getPlaca() {
		return placa;
	}
	/**
	 * @param placa the placa to set
	 */
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	/**
	 * @return the cilindraje
	 */
	public Integer getCilindraje() {
		return cilindraje;
	}
	/**
	 * @param cilindraje the cilindraje to set
	 */
	public void setCilindraje(Integer cilindraje) {
		this.cilindraje = cilindraje;
	}

}
