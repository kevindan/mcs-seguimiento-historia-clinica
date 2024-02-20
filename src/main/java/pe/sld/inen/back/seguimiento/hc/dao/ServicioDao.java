package pe.sld.inen.back.seguimiento.hc.dao;

import java.sql.SQLException;
import java.util.List;

import pe.sld.inen.back.seguimiento.hc.model.Servicio;

public interface ServicioDao {
	
	public List<Servicio> getServicios() throws SQLException, Exception;
}
