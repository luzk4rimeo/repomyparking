/**
 * 
 */
package com.ceiba.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author luz.ocampo
 *
 */
@Entity
public class Registro {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String placa;
	private Integer cilindraje;
	private Date fechahoraingreso;
	private String tipo;
	
	
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the placa
	 */
	public String getPlaca() {
		return placa;
	}
	/**
	 * @param placa the placa to set
	 */
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	/**
	 * @return the cilindraje
	 */
	public Integer getCilindraje() {
		return cilindraje;
	}
	/**
	 * @param cilindraje the cilindraje to set
	 */
	public void setCilindraje(Integer cilindraje) {
		this.cilindraje = cilindraje;
	}
	/**
	 * @return the fechahoraingreso
	 */
	public Date getFechahoraingreso() {
		return fechahoraingreso;
	}
	/**
	 * @param fechahoraingreso the fechahoraingreso to set
	 */
	public void setFechahoraingreso(Date fechahoraingreso) {
		this.fechahoraingreso = fechahoraingreso;
	}
	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}
	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	

	
}
