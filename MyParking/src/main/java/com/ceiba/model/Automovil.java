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
public class Automovil extends Vehiculo implements Cobrable {

	public Automovil(String marca, String color, String placa, Integer cilindraje) {
		super(marca, color, placa, cilindraje);
		// TODO Auto-generated constructor stub
	}

	public Automovil() {
	}

	@Autowired
	ParqueaderoService parqueaderoService;

	@Autowired
	Propiedades propiedades;

	@Override
	public float cobrar(Registro vehiculo) {
		int horas = parqueaderoService.calcularTiempo(vehiculo.getFechahoraingreso());
		
		float total = 0;
		
		/* Mayor a 9 horas en el parqueadero */
		if (horas > 9) {
			
			int horacobrar = horas - 9;
			total = propiedades.getDiaCarro() + (horacobrar * 1000);
			
		} else {

			total = propiedades.getHoraCarro() * horas;
		}

		return total;
	}

}
