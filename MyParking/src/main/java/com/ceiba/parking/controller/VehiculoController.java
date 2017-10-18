package com.ceiba.parking.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.dao.ParqueaderoDaoImp;
import com.ceiba.entity.Registro;
import com.ceiba.model.Automovil;
import com.ceiba.model.Moto;
import com.ceiba.service.ParqueaderoService;

@RestController
public class VehiculoController {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	ParqueaderoService parqueaderoService;

	/** 
	 * Crear DB inicial
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<?> crearmidb() throws Exception {
		System.out.println("Creando tablas");
		parqueaderoService.crearTabla();
		return ResponseEntity.ok(true);

	}

	/**
	 * Registra un automovil en el parqueadero
	 * @param automovil
	 * @return
	 */
	@RequestMapping(value = "/vehiculo/automovil", method = RequestMethod.POST)
	public ResponseEntity<?> ingresarAutomovil(@RequestBody Automovil automovil) {
		boolean registro = this.parqueaderoService.aniadirAutomovil(automovil);
		return ResponseEntity.ok(registro);
	}

	/**
	 * Registra una moto en el parqueadero
	 * @param moto
	 * @return
	 */
	@RequestMapping(value = "/vehiculo/moto", method = RequestMethod.POST)
	public ResponseEntity<?> ingresarMoto(@RequestBody Moto moto) {
		boolean registro = this.parqueaderoService.aniadirMoto(moto);
		return ResponseEntity.ok(registro);
	}
	
	/**
	 * Busca un registro en la base de datos
	 * @param placa
	 * @return
	 */
	@RequestMapping(value = "/buscarregistro", method = RequestMethod.GET)
	public ResponseEntity<Registro> buscarregistro(@RequestParam(value = "placa", defaultValue = "placa") String placa) {
		Registro registro = parqueaderoService.buscarVehiculo(placa);
		System.out.println(registro.getCilindraje());
		return ResponseEntity.ok(registro);
	}
	
//	@RequestMapping(value = "/getcantidadergistros", method = RequestMethod.GET)
//	public ResponseEntity<?> getcantidadergistros(@RequestParam(value = "tipo", defaultValue = "A") String tipo) {
//		int cantidad = parqueaderoService.validarCupoCarro();
//		System.out.println("--->"+cantidad);
//		return ResponseEntity.ok(cantidad);
//	}
	
	/**
	 * Eliminar un registro de la base de datos
	 * @param placa
	 * @return
	 */
	@RequestMapping(value = "/eliminarregistro", method = RequestMethod.DELETE)
	public ResponseEntity<?> eliminarregistro(@RequestParam(value = "placa", defaultValue = "placa") String placa) {
		parqueaderoService.eliminarRegistro(placa);
		return ResponseEntity.ok(true);
	}

}
