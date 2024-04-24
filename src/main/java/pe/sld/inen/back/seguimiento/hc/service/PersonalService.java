package pe.sld.inen.back.seguimiento.hc.service;

import java.util.List;

import pe.sld.inen.back.seguimiento.hc.model.Personal;

public interface PersonalService {
	public List<Personal> getPersonalPorNombres(String nombres) throws Exception;	
	public Personal getPersonalPorId(String idPersonal) throws Exception;	

}
