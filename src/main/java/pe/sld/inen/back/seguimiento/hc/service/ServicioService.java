package pe.sld.inen.back.seguimiento.hc.service;

import java.util.List;

import pe.sld.inen.back.seguimiento.hc.model.Servicio;

public interface ServicioService {
	
	public List<Servicio> getServicios() throws Exception;
}
