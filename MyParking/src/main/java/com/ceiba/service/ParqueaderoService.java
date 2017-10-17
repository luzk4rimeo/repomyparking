/**
 * 
 */
package com.ceiba.service;

import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ceiba.entity.Registro;
import com.ceiba.model.Automovil;
import com.ceiba.model.Moto;
import com.ceiba.model.Vehiculo;

/**
 * @author luz.ocampo
 *
 */
public interface ParqueaderoService {

	boolean aniadirAutomovil(Automovil automovil);

	boolean aniadirMoto(Moto moto);

	boolean validarCupoMoto();

	boolean validarCupoCarro();

	boolean validarPlaca(String placa);

	float validarCilindraje(Integer cilindraje);

	float cobrar(Vehiculo vehiculo);

	void crearTabla();

//	void insertarRegistro(String placa, Integer cilindraje, Date fechahoraingreso, String tipo);
	void insertarRegistro(String placa, Integer cilindraje, String tipo);

	void eliminarRegistro(String placa);

	int getCantidadVehiculoByTipo(String tipo);

	Registro buscarVehiculo(String placa);
	
	

}
