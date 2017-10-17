/**
 * 
 */
package com.ceiba.model;

import com.ceiba.repositorio.Cobrable;

/**
 * @author luz.ocampo
 *
 */
public class Automovil extends Vehiculo implements Cobrable {
	
	
	public Automovil(String marca, String color, String placa, Integer cilindraje) {
		super(marca, color, placa, cilindraje);
		// TODO Auto-generated constructor stub
	}
	
	public Automovil() {}
	
	@Override
	public float cobrar(Vehiculo vehiculo) {
		
		return 0;
	}

}
