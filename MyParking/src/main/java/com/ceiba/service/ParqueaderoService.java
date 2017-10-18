/**
 * 
 */
package com.ceiba.service;

import java.util.Date;
import com.ceiba.entity.Registro;
import com.ceiba.model.Automovil;
import com.ceiba.model.Moto;

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

	float cobrar(Registro vehiculo);

	void crearTabla();

	void insertarRegistro(String placa, Integer cilindraje, String tipo);

	void eliminarRegistro(String placa);

	int getCantidadVehiculoByTipo(String tipo);

	Registro buscarVehiculo(String placa);

	Integer calcularTiempo(Date fecharegistro);
	
	

}
