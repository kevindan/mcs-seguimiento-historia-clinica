package pe.sld.inen.back.seguimiento.hc.dao;

import java.sql.SQLException;
import java.util.List;

import pe.sld.inen.back.seguimiento.hc.model.Medico;

public interface MedicoDao {

	public List<Medico> getMedicos() throws SQLException, Exception;	
}
