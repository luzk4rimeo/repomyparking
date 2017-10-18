package com.ceiba.unitaria;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.ceiba.dao.ParqueaderoDao;
import com.ceiba.entity.Registro;
import com.ceiba.model.Automovil;
import com.ceiba.model.Moto;
import com.ceiba.service.ParqueaderoService;
import com.ceiba.service.ParqueaderoServiceImpl;

public class ParqueaderoTest {

	@Test
	public void validarCupoDisponibleMotoTest() {
		// arrange
		ParqueaderoServiceImpl ParqueaderoServiceImplMock = mock(ParqueaderoServiceImpl.class);
		when(ParqueaderoServiceImplMock.validarCupoMoto()).thenReturn(true);

		// Act
		boolean siCupo = ParqueaderoServiceImplMock.validarCupoMoto();

		// Assert
		assertTrue(siCupo);
	}

	@Test
	public void validarCupoNoDisponibleMotoTest() {
		// arrange
		// ParqueaderoServiceImpl parqueaderoService = new ParqueaderoServiceImpl();
		ParqueaderoServiceImpl ParqueaderoServiceImplMock = mock(ParqueaderoServiceImpl.class);

		Moto motoMock = mock(Moto.class);

		for (int i = 0; i <= 10; i++) {
			ParqueaderoServiceImplMock.aniadirMoto(motoMock);
		}

		// Act
		boolean noCupo = ParqueaderoServiceImplMock.validarCupoMoto();

		// Assert
		assertFalse(noCupo);
	}

	@Test
	public void validarCupoDisponibleCarroTest() {
		// arrange
		ParqueaderoServiceImpl ParqueaderoServiceImplMock = mock(ParqueaderoServiceImpl.class);
		when(ParqueaderoServiceImplMock.validarCupoCarro()).thenReturn(true);

		// Act
		boolean siCupo = ParqueaderoServiceImplMock.validarCupoCarro();

		// Assert
		assertTrue(siCupo);
	}

	@Test
	public void validarCupoNoDisponibleCarroTest() {
		// arrange
		ParqueaderoServiceImpl ParqueaderoServiceImplMock = mock(ParqueaderoServiceImpl.class);
		Automovil autoMock = mock(Automovil.class);
		for (int i = 0; i <= 20; i++) {
			ParqueaderoServiceImplMock.aniadirAutomovil(autoMock);
		}

		// Act
		boolean noCupo = ParqueaderoServiceImplMock.validarCupoCarro();

		// Assert
		assertFalse(noCupo);
	}

	@Test
	public void validarPlacatest() {
		// arrange
		ParqueaderoServiceImpl parqueaderoServiceImpl = new ParqueaderoServiceImpl();
		// Act
		boolean vardisponible = parqueaderoServiceImpl.validarPlaca("APY635");

		// Assert
		assertTrue(vardisponible);
	}

	@Test
	public void aniadirVehiculoAutoTest() {
		// arrange
		ParqueaderoServiceImpl ParqueaderoServiceImplMock = mock(ParqueaderoServiceImpl.class);
		Automovil autoMock = mock(Automovil.class);
		when(ParqueaderoServiceImplMock.getCantidadVehiculoByTipo("A")).thenReturn(1);
		// Act
		ParqueaderoServiceImplMock.aniadirAutomovil(autoMock);

		System.out.println(ParqueaderoServiceImplMock.getCantidadVehiculoByTipo("A"));
		assertTrue(ParqueaderoServiceImplMock.getCantidadVehiculoByTipo("A") > 0);

	}

	@Test
	public void aniadirVehiculoMotoTest() {
		// arrange
		ParqueaderoServiceImpl ParqueaderoServiceImplMock = mock(ParqueaderoServiceImpl.class);

		Moto motoMock = mock(Moto.class);
		when(ParqueaderoServiceImplMock.getCantidadVehiculoByTipo("M")).thenReturn(1);

		// Act
		ParqueaderoServiceImplMock.aniadirMoto(motoMock);

		// ASsert
		assertTrue(ParqueaderoServiceImplMock.getCantidadVehiculoByTipo("M") > 0);

	}

	@Test
	public void validarCilindrajeMayor() {
		// Arrange
		ParqueaderoServiceImpl parqueaderoService = new ParqueaderoServiceImpl();
		Moto moto = new Moto();
		moto.setCilindraje(600);

		// Act
		float valorPorCilindraje = parqueaderoService.validarCilindraje(moto.getCilindraje());

		// Assert
		assert (valorPorCilindraje == 2000);
	}

	@Test
	public void validarCilindrajeMenor() {
		// Arrange
		ParqueaderoServiceImpl parqueaderoService = new ParqueaderoServiceImpl();
		Moto moto = new Moto();
		moto.setCilindraje(450);

		// Act
		float valorPorCilindraje = parqueaderoService.validarCilindraje(moto.getCilindraje());

		// Assert
		assert (valorPorCilindraje == 0);
	}

	@Test
	public void calcularTiempoTest() {
		// Arrange
		ParqueaderoServiceImpl parqueaderoService = new ParqueaderoServiceImpl();

		// Act
		Calendar c = Calendar.getInstance();
		c.set(2017, 9, 18, 6, 00);

		int horas = parqueaderoService.calcularTiempo(c.getTime());

		// Assert
		assertTrue(horas > 0);
	}

}
