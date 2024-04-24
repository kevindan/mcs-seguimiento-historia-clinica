package pe.sld.inen.back.seguimiento.hc.service;

import java.util.List;

import pe.sld.inen.back.seguimiento.hc.model.Medico;

public interface MedicoService {

	public List<Medico> getMedicosPorNombres(String nombres) throws Exception;	
	public Medico getMedicoPorId(String idMedico) throws Exception;	
}
