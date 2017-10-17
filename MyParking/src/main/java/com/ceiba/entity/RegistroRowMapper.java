/**
 * 
 */
package com.ceiba.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * @author luz.ocampo
 *
 */
public class RegistroRowMapper implements RowMapper<Registro> {

	public Registro mapRow(ResultSet rs, int i) throws SQLException {
		Registro p = new Registro();
		p.setId(rs.getInt("ID"));
		p.setPlaca(rs.getString("PLACA"));
		p.setCilindraje(rs.getInt("CILINDRAJE"));
		p.setTipo(rs.getString("TIPO"));
		return p;
	}
}
