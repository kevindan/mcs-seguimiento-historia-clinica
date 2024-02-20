package pe.sld.inen.back.seguimiento.hc.service;

import java.util.List;

import pe.sld.inen.back.seguimiento.hc.bean.request.RegistrarEntregaRequest;
import pe.sld.inen.back.seguimiento.hc.bean.response.GenericResponse;
import pe.sld.inen.back.seguimiento.hc.model.Movimiento;

public interface MovimientoService {
	
	public GenericResponse registraEntrega(RegistrarEntregaRequest registrarEntregaRequest) throws Exception; 
	public List<Movimiento> consultarMovimiento(String numeroHistoriaClinica) throws Exception;
	
	
}
