package pe.sld.inen.back.seguimiento.hc.dao;

import java.sql.SQLException;
import java.util.List;

import pe.sld.inen.back.seguimiento.hc.model.Personal;

public interface PersonalDao {
	public List<Personal> getPersonalPorNombres(String nombres) throws SQLException, Exception;	
	public Personal getPersonalPorId(String idPersonal) throws SQLException, Exception;	
}
