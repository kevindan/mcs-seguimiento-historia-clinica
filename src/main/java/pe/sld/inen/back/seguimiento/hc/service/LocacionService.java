package pe.sld.inen.back.seguimiento.hc.service;

import java.util.List;

import pe.sld.inen.back.seguimiento.hc.model.Locacion;

public interface LocacionService {
	
	public List<Locacion> getLocaciones() throws Exception;

}
