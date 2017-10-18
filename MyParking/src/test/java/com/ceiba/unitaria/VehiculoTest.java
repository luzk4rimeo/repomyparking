/**
 * 
 */
package com.ceiba.unitaria;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ceiba.databuilder.VehiculoTestDataBuilder;
import com.ceiba.model.Vehiculo;

/**
 * @author luz.ocampo
 *
 */
public class VehiculoTest {

	private static final Integer CILINDRAJE = 1250;
	private static final String MARCA = "KIA";
	private static final String COLOR = "AZUL";
	private static final String PLACA = "ABC123";

	@Test
	public void crearVehiculoTest() {
		// arrange
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conMarca("KIA")
				.conPlaca("ABC123").conCilindraje(1250).conColor("AZUL");

		// act
		Vehiculo vehiculo = vehiculoTestDataBuilder.build();

		// assert
		assertEquals(MARCA, vehiculo.getMarca());
		assertEquals(PLACA, vehiculo.getPlaca());
		assertEquals(COLOR, vehiculo.getColor());
		assertEquals(CILINDRAJE, vehiculo.getCilindraje());
	}

}
