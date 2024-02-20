package pe.sld.inen.back.seguimiento.hc.dao;

import java.sql.SQLException;
import java.util.List;

import pe.sld.inen.back.seguimiento.hc.model.Paciente;

public interface PacienteDao {
	
	public List<Paciente> getPacientesPorDni(String dni) throws SQLException, Exception;

}
