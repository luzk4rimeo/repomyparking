/**
 * 
 */
package com.ceiba.model;

import com.ceiba.repositorio.Cobrable;

/**
 * @author luz.ocampo
 *
 */
public class Moto extends Vehiculo implements Cobrable {

	public Moto(String marca, String color, String placa, Integer cilindraje) {
		super(marca, color, placa, cilindraje);
		// TODO Auto-generated constructor stub
	}
	
	public Moto() {
		super();
	}

	@Override
	public float cobrar(Vehiculo vehiculo) {
		return 0;
	}

}
