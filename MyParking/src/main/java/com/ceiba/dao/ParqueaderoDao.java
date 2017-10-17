/**
 * 
 */
package com.ceiba.dao;

import java.util.Date;
import java.util.List;

import com.ceiba.entity.Registro;

/**
 * @author luz.ocampo
 *
 */
public interface ParqueaderoDao {

	void crearTablaInicial();

//	void ingresarVehiculo(String placa, Integer cilindraje, Date fechahoraingreso, String tipo);
	void ingresarVehiculo(String placa, Integer cilindraje, String tipo);

	void eliminarVehiculo(String placa);

	void getVehiculosAll();

	List<Registro> getVehiculoByTipo(String tipo);

	Integer getCantidadByTipo(String tipo);

	Registro buscarVehiculo(String placa);
	
}
