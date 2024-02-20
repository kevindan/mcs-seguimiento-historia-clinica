package pe.sld.inen.back.seguimiento.hc.dao;

import java.sql.SQLException;
import java.util.List;

import pe.sld.inen.back.seguimiento.hc.model.Motivo;

public interface MotivoDao {
	
	public List<Motivo> getMotivos() throws SQLException, Exception;

}
