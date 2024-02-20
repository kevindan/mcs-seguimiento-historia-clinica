package pe.sld.inen.back.seguimiento.hc.dao;

import java.sql.SQLException;
import java.util.List;

import pe.sld.inen.back.seguimiento.hc.model.Departamento;

public interface DepartamentoDao {
	
	public List<Departamento> getDepartamentos(Integer idServicio) throws SQLException, Exception;
}
