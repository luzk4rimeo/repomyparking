/**
 * 
 */
package com.ceiba.model;

import org.springframework.beans.factory.annotation.Autowired;

import com.ceiba.entity.Registro;
import com.ceiba.repositorio.Cobrable;
import com.ceiba.service.ParqueaderoService;

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

	@Autowired
	ParqueaderoService parqueaderoService;

	@Autowired
	Propiedades propiedades;

	@Override
	public float cobrar(Registro vehiculo) {
		int horas = parqueaderoService.calcularTiempo(vehiculo.getFechahoraingreso());
		float adicional = parqueaderoService.validarCilindraje(vehiculo.getCilindraje());
		float total = (horas * propiedades.getHoraMoto() + adicional);
		return total;
	}

}
