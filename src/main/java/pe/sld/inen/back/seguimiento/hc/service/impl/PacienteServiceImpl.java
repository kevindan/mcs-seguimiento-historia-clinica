package pe.sld.inen.back.seguimiento.hc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.sld.inen.back.seguimiento.hc.dao.PacienteDao;
import pe.sld.inen.back.seguimiento.hc.model.Paciente;
import pe.sld.inen.back.seguimiento.hc.service.PacienteService;

@Service
public class PacienteServiceImpl implements PacienteService {

	@Autowired
	private PacienteDao pacienteDao;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());	
	
	@Override
	public List<Paciente> getPacientesPorDni(String dni) throws Exception {
		List<Paciente> pacientes = new ArrayList<Paciente>();
		try {
			pacientes = pacienteDao.getPacientesPorDni(dni);
		} catch (Exception e) {
			logger.error("Error en getPacientesPorDni ==> "+e.getMessage());
			throw e;
		}
		return pacientes;
	}

}
