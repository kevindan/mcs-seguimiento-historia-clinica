package pe.sld.inen.back.seguimiento.hc.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import pe.sld.inen.back.seguimiento.hc.model.Medico;
import pe.sld.inen.back.seguimiento.hc.model.Personal;

public class PersonalRowMapper implements RowMapper<Personal> {

	@Override
	public Personal mapRow(ResultSet rs, int rowNum) throws SQLException {
		Personal personal = new Personal();
		personal.setIdPersonal(rs.getString("id_personal"));
		personal.setPersonal(rs.getString("personal"));
		return personal;
	}

}
