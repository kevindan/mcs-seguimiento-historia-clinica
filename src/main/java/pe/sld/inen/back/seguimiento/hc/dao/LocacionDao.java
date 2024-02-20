package pe.sld.inen.back.seguimiento.hc.dao;

import java.sql.SQLException;
import java.util.List;

import pe.sld.inen.back.seguimiento.hc.model.Locacion;

public interface LocacionDao {
	
	public List<Locacion> getLocaciones() throws SQLException, Exception;

}
