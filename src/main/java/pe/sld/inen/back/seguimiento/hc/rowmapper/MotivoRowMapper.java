package pe.sld.inen.back.seguimiento.hc.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import pe.sld.inen.back.seguimiento.hc.model.Motivo;

public class MotivoRowMapper implements RowMapper<Motivo> {

	@Override
	public Motivo mapRow(ResultSet rs, int rowNum) throws SQLException {
		Motivo motivo = new Motivo();
		motivo.setId_motivo(rs.getString("id_motivo"));
		motivo.setMotivo(rs.getString("motivo"));
		return motivo;
	}

}
