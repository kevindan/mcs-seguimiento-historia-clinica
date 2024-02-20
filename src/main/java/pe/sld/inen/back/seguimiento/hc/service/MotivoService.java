package pe.sld.inen.back.seguimiento.hc.service;

import java.util.List;

import pe.sld.inen.back.seguimiento.hc.model.Motivo;

public interface MotivoService {
	
	public List<Motivo> getMotivos() throws Exception;

}
