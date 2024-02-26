package pe.sld.inen.back.seguimiento.hc.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import pe.sld.inen.back.seguimiento.hc.model.Departamento;

public class DepartamentoRowMapper implements RowMapper<Departamento> {

	@Override
	public Departamento mapRow(ResultSet rs, int rowNum) throws SQLException {
		Departamento departamento = new Departamento();
		departamento.setId_departamento(rs.getString("id_departamento"));
		departamento.setDepartamento(rs.getString("departamento"));		
		return departamento;
	}

}
