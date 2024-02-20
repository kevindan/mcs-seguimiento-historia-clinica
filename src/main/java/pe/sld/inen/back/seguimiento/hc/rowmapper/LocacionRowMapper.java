package pe.sld.inen.back.seguimiento.hc.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import pe.sld.inen.back.seguimiento.hc.model.Locacion;

public class LocacionRowMapper implements RowMapper<Locacion> {

	@Override
	public Locacion mapRow(ResultSet rs, int rowNum) throws SQLException {
		Locacion locacion = new Locacion();
		locacion.setId_locacion(rs.getInt("id_locacion"));
		locacion.setLocacion(rs.getString("locacion"));
		return locacion;
	}

}
