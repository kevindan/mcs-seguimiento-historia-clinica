package pe.sld.inen.back.seguimiento.hc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.sld.inen.back.seguimiento.hc.dao.MotivoDao;
import pe.sld.inen.back.seguimiento.hc.model.Motivo;
import pe.sld.inen.back.seguimiento.hc.service.MotivoService;

@Service
public class MotivoServiceImpl implements MotivoService {

	@Autowired
	private MotivoDao motivoDao;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public List<Motivo> getMotivos() throws Exception {
		List<Motivo> motivos = new ArrayList<Motivo>();
		try {
			motivos = motivoDao.getMotivos();
		} catch (Exception e) {
			logger.error("Error en getMotivos ==> "+e.getMessage());
			throw e;
		}
		return motivos;
	
	}

}
