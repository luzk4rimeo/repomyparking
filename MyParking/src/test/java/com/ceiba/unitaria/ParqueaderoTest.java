package com.ceiba.unitaria;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Calendar;
import java.util.Date;

import javax.validation.constraints.AssertTrue;

import org.junit.Test;

import com.ceiba.model.Automovil;
import com.ceiba.model.Moto;
import com.ceiba.model.Vehiculo;
import com.ceiba.service.ParqueaderoServiceImpl;

public class ParqueaderoTest {

	@Test
	public void validarCupoDisponibleMotoTest() {
		// arrange
		ParqueaderoServiceImpl parqueadero = new ParqueaderoServiceImpl();

		// Act
		boolean siCupo = parqueadero.validarCupoMoto();

		// Assert
		assertTrue(siCupo);
	}

	@Test
	public void validarCupoNoDisponibleMotoTest() {
		// arrange
		ParqueaderoServiceImpl parqueadero = new ParqueaderoServiceImpl();
		Moto moto = new Moto();
		for (int i = 0; i <= 10; i++) {
			parqueadero.getListMoto().add(moto);
		}

		// Act
		boolean noCupo = parqueadero.validarCupoMoto();

		// Assert
		assertFalse(noCupo);
	}

	@Test
	public void validarCupoDisponibleCarroTest() {
		// arrange
		ParqueaderoServiceImpl parqueadero = new ParqueaderoServiceImpl();

		// Act
		boolean siCupo = parqueadero.validarCupoCarro();

		// Assert
		assertTrue(siCupo);
	}

	@Test
	public void validarCupoNoDisponibleCarroTest() {
		// arrange
		ParqueaderoServiceImpl parqueadero = new ParqueaderoServiceImpl();
		Automovil auto = new Automovil();
		for (int i = 0; i <= 20; i++) {
			parqueadero.getListAutomovil().add(auto);
		}

		// Act
		boolean noCupo = parqueadero.validarCupoCarro();

		// Assert
		assertFalse(noCupo);
	}

	@Test
	public void validarPlacatest() {
		// arrange
		ParqueaderoServiceImpl parqueadero = new ParqueaderoServiceImpl();
		// Act
		boolean vardisponible = parqueadero.validarPlaca("APY635");

		// Assert
		assertTrue(vardisponible);
	}

	@Test
	public void aniadirVehiculoAutoTest() {
		// Arrange
		ParqueaderoServiceImpl parqueadero = new ParqueaderoServiceImpl();

		Automovil auto = new Automovil("KiaPicanto", "Gris", "IPY735", 1250);

		// Act
//		boolean agregaVehiculo = parqueadero.aniadirVehiculo(auto);

//		 ASsert
//		assertTrue(agregaVehiculo);

	}

	@Test
	public void aniadirVehiculoMotoTest() {
		// Arrange
		ParqueaderoServiceImpl parqueadero = new ParqueaderoServiceImpl();

		Moto moto = new Moto("AKT", "Gris", "ASB12B", 300);

		// Act
//		boolean agregaVehiculo = parqueadero.aniadirVehiculo(moto);

		// ASsert
//		assertTrue(agregaVehiculo);

	}

	@Test
	public void validarCilindrajeMayor() {
		// Arrange
		ParqueaderoServiceImpl parqueadero = new ParqueaderoServiceImpl();
		Moto moto = new Moto();
		moto.setCilindraje(600);

		// Act
		float valorPorCilindraje = parqueadero.validarCilindraje(moto.getCilindraje());

		// Assert
		assert (valorPorCilindraje == 2000);
	}

	@Test
	public void validarCilindrajeMenor() {
		// Arrange
		ParqueaderoServiceImpl parqueadero = new ParqueaderoServiceImpl();
		Moto moto = new Moto();
		moto.setCilindraje(450);

		// Act
		float valorPorCilindraje = parqueadero.validarCilindraje(moto.getCilindraje());

		// Assert
		assert (valorPorCilindraje == 0);
	}

	@Test
	public void cobrarTest() {
		// Arrange
		ParqueaderoServiceImpl parqueadero = new ParqueaderoServiceImpl();

		Automovil automovil = mock(Automovil.class);
		
		parqueadero.cobrar(automovil);
		
	}

}
