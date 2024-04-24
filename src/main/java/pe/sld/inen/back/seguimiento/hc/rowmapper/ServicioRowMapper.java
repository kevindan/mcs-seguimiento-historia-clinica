package pe.sld.inen.back.seguimiento.hc.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import pe.sld.inen.back.seguimiento.hc.model.Servicio;

public class ServicioRowMapper implements RowMapper<Servicio> {

	@Override
	public Servicio mapRow(ResultSet rs, int rowNum) throws SQLException {
		Servicio servicio = new Servicio();
		servicio.setId_servicio(rs.getString("id_servicio"));
		servicio.setServicio(rs.getString("servicio"));
		return servicio;
	}

}
