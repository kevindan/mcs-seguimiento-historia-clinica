package pe.sld.inen.back.seguimiento.hc.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import pe.sld.inen.back.seguimiento.hc.model.Movimiento;

public class MovimientoRowMapper implements RowMapper<Movimiento>{

	@Override
	public Movimiento mapRow(ResultSet rs, int rowNum) throws SQLException {
		Movimiento movimiento = new Movimiento();

		movimiento.setHora(rs.getString("hora"));
		movimiento.setFecha(rs.getString("fecha"));
		movimiento.setId_motivo(rs.getInt("id_motivo"));
		movimiento.setId_empleado(rs.getInt("id_empleado"));
		movimiento.setId_locacion(rs.getInt("id_locacion"));
		movimiento.setId_servicio(rs.getInt("id_servicio"));
		movimiento.setMotivo_desc(rs.getString("motivo_desc"));
		movimiento.setObservacion(rs.getString("observacion"));
		movimiento.setEmpleado_desc(rs.getString("empleado_desc"));
		movimiento.setLocacion_desc(rs.getString("locacion_desc"));
		movimiento.setServicio_desc(rs.getString("servicio_desc"));
		movimiento.setId_departamento(rs.getInt("id_departamento"));
		movimiento.setDepartamento_desc(rs.getString("departamento_desc"));
		movimiento.setMedico_solicitante(rs.getString("medico_solicitante"));
		movimiento.setId_medico_solicitante(rs.getInt("id_medico_solicitante"));
		
		return movimiento;
	}

}
