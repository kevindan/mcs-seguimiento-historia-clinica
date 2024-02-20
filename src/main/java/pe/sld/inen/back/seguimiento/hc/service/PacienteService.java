package pe.sld.inen.back.seguimiento.hc.service;

import java.util.List;

import pe.sld.inen.back.seguimiento.hc.model.Paciente;

public interface PacienteService {
	
	public List<Paciente> getPacientesPorDni(String dni) throws Exception;

}
