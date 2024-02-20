package pe.sld.inen.back.seguimiento.hc.service;

import java.util.List;

import pe.sld.inen.back.seguimiento.hc.model.Departamento;

public interface DepartamentoService {
	
	public List<Departamento> getDepartamentos(Integer idServicio) throws Exception;
}
