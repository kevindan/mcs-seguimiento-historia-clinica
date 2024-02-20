package pe.sld.inen.back.seguimiento.hc.dao;

import java.sql.SQLException;
import java.util.List;

import pe.sld.inen.back.seguimiento.hc.bean.request.RegistrarEntregaRequest;
import pe.sld.inen.back.seguimiento.hc.bean.response.GenericResponse;
import pe.sld.inen.back.seguimiento.hc.model.Movimiento;

public interface MovimientoDao {
	
	public GenericResponse registraEntrega(RegistrarEntregaRequest registrarEntregaRequest) throws SQLException, Exception; 
	public List<Movimiento> consultarMovimiento(String numeroHistoriaClinica) throws SQLException, Exception;
	
	
}
