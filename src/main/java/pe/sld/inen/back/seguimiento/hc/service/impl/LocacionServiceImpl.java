package pe.sld.inen.back.seguimiento.hc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.sld.inen.back.seguimiento.hc.dao.LocacionDao;
import pe.sld.inen.back.seguimiento.hc.model.Locacion;
import pe.sld.inen.back.seguimiento.hc.service.LocacionService;

@Service
public class LocacionServiceImpl implements LocacionService {
	
	@Autowired
	private LocacionDao locacionDao;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public List<Locacion> getLocaciones() throws Exception {
		List<Locacion> locacion = new ArrayList<Locacion>();
		try {
			locacion = locacionDao.getLocaciones();
		} catch (Exception e) {
			logger.error("Error en getLocaciones ==> "+e.getMessage());
			throw e;
		}
		return locacion;
	}

}
