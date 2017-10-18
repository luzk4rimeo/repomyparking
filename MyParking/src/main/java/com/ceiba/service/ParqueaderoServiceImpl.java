/**
 * 
 */
package com.ceiba.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.dao.ParqueaderoDao;
import com.ceiba.entity.Registro;
import com.ceiba.model.Automovil;
import com.ceiba.model.Moto;
import com.ceiba.model.Vehiculo;

/**
 * @author luz.ocampo
 *
 */
@Service
public class ParqueaderoServiceImpl implements ParqueaderoService {

	private List<Automovil> listAutomovil = new ArrayList<>();
	private List<Moto> listMoto = new ArrayList<>();
	private Integer cupoCarro = 20;
	private Integer cupoMoto = 10;
	private final String letraPlaca = "A";

	@Autowired
	ParqueaderoDao parqueaderoDao;

	/**
	 * @return the listAutomovil
	 */
	public List<Automovil> getListAutomovil() {
		return listAutomovil;
	}

	/**
	 * @param listAutomovil
	 *            the listAutomovil to set
	 */
	public void setListAutomovil(List<Automovil> listAutomovil) {
		this.listAutomovil = listAutomovil;
	}

	/**
	 * @return the listMoto
	 */
	public List<Moto> getListMoto() {
		return listMoto;
	}

	/**
	 * @param listMoto
	 *            the listMoto to set
	 */
	public void setListMoto(List<Moto> listMoto) {
		this.listMoto = listMoto;
	}

	/**
	 * @return the cupoCarro
	 */
	public Integer getCupoCarro() {
		return cupoCarro;
	}

	/**
	 * @param cupoCarro
	 *            the cupoCarro to set
	 */
	public void setCupoCarro(Integer cupoCarro) {
		this.cupoCarro = cupoCarro;
	}

	/**
	 * @return the cupoMoto
	 */
	public Integer getCupoMoto() {
		return cupoMoto;
	}

	/**
	 * @param cupoMoto
	 *            the cupoMoto to set
	 */
	public void setCupoMoto(Integer cupoMoto) {
		this.cupoMoto = cupoMoto;
	}

	@Override
	public boolean aniadirAutomovil(Automovil automovil) {
		if (validarPlaca(automovil.getPlaca())) {
			if (validarCupoCarro()) {
				insertarRegistro(automovil.getPlaca(), automovil.getCilindraje(), "A");
				return true;
			}
		}
		return false;
	}

	/**
	 * Permite agregar una moto especificamente a la lista del parqueadero
	 * 
	 * @param moto
	 * @return
	 */
	@Override
	public boolean aniadirMoto(Moto moto) {
		if (validarCupoMoto()) {
			insertarRegistro(moto.getPlaca(), moto.getCilindraje(), "M");
			return true;
		}
		return false;
	}

	public boolean retirarVehiculo(Vehiculo vehiculo) {
		return true;
	}

	/**
	 * Compara el cupo con el tamanio actual de la lista para definir si hay cupo
	 * para Moto
	 * 
	 * @return
	 */
	@Override
	public boolean validarCupoMoto() {
		int ocupados = getCantidadVehiculoByTipo("M");
		if ((this.cupoMoto - ocupados) > 0) {
			return true;
		}

		return false;
	}

	/**
	 * Compara el cupo con el tamanio actual de la lista para definir si hay cupo
	 * para Carro
	 * 
	 * @return
	 */
	@Override
	public boolean validarCupoCarro() {
		int ocupados = getCantidadVehiculoByTipo("A");
		if (ocupados != 0) {
			if ((this.cupoCarro - ocupados) > 0) {
				return true;
			}
		}
		return true;
	}

	/**
	 * Valida que la primer letra de la placa y el dia de la semana segun las reglas
	 * 
	 * @param placa
	 * @return
	 */
	@Override
	public boolean validarPlaca(String placa) {
		String primer_letra;

		primer_letra = placa.substring(0, 1);
		LocalDate fechaActual = LocalDate.now();
		if (letraPlaca.equals(primer_letra)
				&& ("MONDAY".equals(fechaActual.getDayOfWeek()) || "SUNDAY".equals(fechaActual.getDayOfWeek()))) {
			return false;
		}
		return true;
	}

	/**
	 * Valida si el cilindraje es mayor a 500cc
	 * 
	 * @param cilindraje
	 * @return
	 */
	@Override
	public float validarCilindraje(Integer cilindraje) {
		System.out.println("Ingreso");
		if (cilindraje != null) {
			if (cilindraje > 500) {
				return 2000;
			}
		}
		return 0;
	}

	/**
	 * Calcula el valor a pagar de acuero a las reglas de negocio
	 * 
	 * @param vehiculo
	 * @return
	 */
	@Override
	public float cobrar(Registro registro) {
		
		if (registro.getTipo().equals("A")) {
			Automovil auto = new Automovil();
			return auto.cobrar(registro);
		} else {
			Moto moto = new Moto();
			return moto.cobrar(registro);
		}

	}

	@Override
	public Integer calcularTiempo(Date fecharegistro) {
		Calendar c = Calendar.getInstance();

		Calendar fechaInicio = new GregorianCalendar();
		fechaInicio.setTime(new Date());

		Calendar fechaFin = new GregorianCalendar();
		fechaFin.setTime(fecharegistro);
		c.setTimeInMillis(fechaInicio.getTime().getTime() - fechaFin.getTime().getTime());
		
		return (int) (c.getTimeInMillis() / 3600000);
	}

	@Override
	public void crearTabla() {
		parqueaderoDao.crearTablaInicial();
	}

	@Override
	public void insertarRegistro(String placa, Integer cilindraje, String tipo) {
		parqueaderoDao.ingresarVehiculo(placa, cilindraje, tipo);
	}

	@Override
	public void eliminarRegistro(String placa) {
		parqueaderoDao.eliminarVehiculo(placa);
	}

	@Override
	public int getCantidadVehiculoByTipo(String tipo) {

		return parqueaderoDao.getCantidadByTipo(tipo);
	}

	@Override
	public Registro buscarVehiculo(String placa) {
		return parqueaderoDao.buscarVehiculo(placa);
	}

}
