package pe.sld.inen.back.seguimiento.hc.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import pe.sld.inen.back.seguimiento.hc.model.Medico;

public class MedicoRowMapper implements RowMapper<Medico> {

	@Override
	public Medico mapRow(ResultSet rs, int rowNum) throws SQLException {
		Medico medico = new Medico();
		medico.setId_medico(rs.getString("id_medico"));
		medico.setMedico(rs.getString("medico"));
		return medico;
	}

}
