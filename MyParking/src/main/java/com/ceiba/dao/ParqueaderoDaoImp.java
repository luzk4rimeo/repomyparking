package com.ceiba.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.ceiba.entity.Registro;
import com.ceiba.entity.RegistroRowMapper;

@Component
public class ParqueaderoDaoImp implements ParqueaderoDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void crearTablaInicial() {
		String sql = "CREATE TABLE registro(id SERIAL, placa VARCHAR(255), cilindraje INTEGER(11), tipo VARCHAR(255), fechahoraingreso TIMESTAMP)";
		jdbcTemplate.execute(sql);
	}

	@Override
	public void ingresarVehiculo(String placa, Integer cilindraje, String tipo) {
		Date fecha = new Date();
		String sql = "INSERT INTO registro(placa,cilindraje,tipo,fechahoraingreso) VALUES (?, ?, ?,?)";
		this.jdbcTemplate.update(sql, placa, cilindraje, tipo, fecha);
	}

	@Override
	public void eliminarVehiculo(String placa) {
		String sql = "DELETE FROM registro WHERE placa =?";
		this.jdbcTemplate.update(sql, placa);
	}

	@Override
	public void getVehiculosAll() {
		String sql = "SELECT * FROM registro";
		jdbcTemplate.execute(sql);
	}

	@Override
	public List<Registro> getVehiculoByTipo(String tipo) {
		String sql = "SELECT * FROM registro WHERE tipo='" + tipo + "'";

		return this.jdbcTemplate.query(sql, new RowMapper<Registro>() {
			@Override
			public Registro mapRow(ResultSet rs, int i) throws SQLException {
				Registro r = new Registro();
				r.setPlaca(rs.getString("PLACA"));
				r.setCilindraje(rs.getInt("CILINDRAJE"));
				r.setTipo(rs.getString("TIPO"));
				return r;
			}
		});

	}

	@Override
	public Integer getCantidadByTipo(String tipo) {
		String sql = "SELECT count(*) FROM registro WHERE tipo='" + tipo + "'";
		Integer result = this.jdbcTemplate.queryForObject(sql, Integer.class);
		if (result != null) {
			return result;
		}
		return 0;
	}

	@Override
	public Registro buscarVehiculo(String placa) {
		String sql = "SELECT * FROM registro WHERE PLACA = ?";
		return this.jdbcTemplate.queryForObject(sql, new RegistroRowMapper(), placa);
	}

}
