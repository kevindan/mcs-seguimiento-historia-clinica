package pe.sld.inen.back.seguimiento.hc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.sld.inen.back.seguimiento.hc.dao.MedicoDao;
import pe.sld.inen.back.seguimiento.hc.model.Medico;
import pe.sld.inen.back.seguimiento.hc.service.MedicoService;

@Service
public class MedicoServiceImpl implements MedicoService {

	@Autowired
	private MedicoDao medicoDao;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public List<Medico> getMedicosPorNombres(String nombres) throws Exception {
		List<Medico> medicos = new ArrayList<Medico>();
		try {
			medicos = medicoDao.getMedicosPorNombres(nombres);
		} catch (Exception e) {
			logger.error("Error en getMedicosPorNombres ==> "+e.getMessage());
			throw e;
		}
		return medicos;
	}

	@Override
	public Medico getMedicoPorId(String idMedico) throws Exception {
		Medico medico = null;
		try {
			medico = medicoDao.getMedicoPorId(idMedico);
		} catch (Exception e) {
			logger.error("Error en getMedicoPorId ==> "+e.getMessage());
			throw e;
		}
		return medico;
	}

}
