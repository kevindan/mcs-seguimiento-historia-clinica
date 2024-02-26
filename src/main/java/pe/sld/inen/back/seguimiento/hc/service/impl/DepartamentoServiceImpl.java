package pe.sld.inen.back.seguimiento.hc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.sld.inen.back.seguimiento.hc.dao.DepartamentoDao;
import pe.sld.inen.back.seguimiento.hc.model.Departamento;
import pe.sld.inen.back.seguimiento.hc.service.DepartamentoService;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {
		
	@Autowired
	private DepartamentoDao departamentoDao;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public List<Departamento> getDepartamentos() throws Exception {
		List<Departamento> departamentos = new ArrayList<>();
		try {
			departamentos = departamentoDao.getDepartamentos();
		} catch (Exception e) {
			logger.error("Error en getDepartamentos ==> "+e.getMessage());
			throw e;
		}
		return departamentos;
	}		

}
