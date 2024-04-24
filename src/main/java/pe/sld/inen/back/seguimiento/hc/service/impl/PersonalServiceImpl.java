package pe.sld.inen.back.seguimiento.hc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.sld.inen.back.seguimiento.hc.dao.MedicoDao;
import pe.sld.inen.back.seguimiento.hc.dao.PersonalDao;
import pe.sld.inen.back.seguimiento.hc.model.Medico;
import pe.sld.inen.back.seguimiento.hc.model.Personal;
import pe.sld.inen.back.seguimiento.hc.service.MedicoService;
import pe.sld.inen.back.seguimiento.hc.service.PersonalService;

@Service
public class PersonalServiceImpl implements PersonalService {

	@Autowired
	private PersonalDao personalDao;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public List<Personal> getPersonalPorNombres(String nombres) throws Exception {
		List<Personal> personal = new ArrayList<Personal>();
		try {
			personal = personalDao.getPersonalPorNombres(nombres);
		} catch (Exception e) {
			logger.error("Error en getPersonalPorNombres ==> "+e.getMessage());
			throw e;
		}
		return personal;
	}

	@Override
	public Personal getPersonalPorId(String idPersonal) throws Exception {
		Personal personal = null;
		try {
			personal = personalDao.getPersonalPorId(idPersonal);
		} catch (Exception e) {
			logger.error("Error en getPersonalPorId ==> "+e.getMessage());
			throw e;
		}
		return personal;
	}

}
