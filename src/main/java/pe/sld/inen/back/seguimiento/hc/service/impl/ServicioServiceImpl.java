package pe.sld.inen.back.seguimiento.hc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.sld.inen.back.seguimiento.hc.dao.ServicioDao;
import pe.sld.inen.back.seguimiento.hc.model.Servicio;
import pe.sld.inen.back.seguimiento.hc.service.ServicioService;

@Service
public class ServicioServiceImpl implements ServicioService {

	@Autowired
	private ServicioDao servicioDao;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public List<Servicio> getServicios() throws Exception {
		List<Servicio> servicios = new ArrayList<>();
		try {
			servicios = servicioDao.getServicios();
		} catch (Exception e) {
			logger.error("Error en getServicios ==> "+e.getMessage());
			throw e;			
		}
		return servicios;
	}

}
