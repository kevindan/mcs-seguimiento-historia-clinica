package pe.sld.inen.back.seguimiento.hc.service;

import java.util.List;

import pe.sld.inen.back.seguimiento.hc.model.Medico;

public interface MedicoService {

	public List<Medico> getMedicos() throws Exception;	
}
