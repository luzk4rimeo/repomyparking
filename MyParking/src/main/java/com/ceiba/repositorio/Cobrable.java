package com.ceiba.repositorio;

import com.ceiba.model.Vehiculo;

public interface Cobrable{

	/**
	 * Permite cobrar por el tiempo de permanencia en el parqueadero
	 * @param vehiculo
	 * @return
	 */
	public float cobrar(Vehiculo vehiculo);
}
