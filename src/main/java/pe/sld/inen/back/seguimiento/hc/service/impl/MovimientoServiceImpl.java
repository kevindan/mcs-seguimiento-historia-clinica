package pe.sld.inen.back.seguimiento.hc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.sld.inen.back.seguimiento.hc.bean.request.RegistrarEntregaRequest;
import pe.sld.inen.back.seguimiento.hc.bean.response.GenericResponse;
import pe.sld.inen.back.seguimiento.hc.dao.MovimientoDao;
import pe.sld.inen.back.seguimiento.hc.model.Movimiento;
import pe.sld.inen.back.seguimiento.hc.service.MovimientoService;

@Service
public class MovimientoServiceImpl implements MovimientoService {

	@Autowired
	private MovimientoDao movimientoDao;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public GenericResponse registraEntrega(RegistrarEntregaRequest registrarEntregaRequest) throws Exception {
		GenericResponse response = new GenericResponse();
		try {
			response = movimientoDao.registraEntrega(registrarEntregaRequest);
		} catch (Exception e) {
			logger.error("Error en registraEntrega ==> " + e.getMessage());
			throw e;
		}
		return response;
	}

	@Override
	public List<Movimiento> consultarMovimiento(String numeroHistoriaClinica) throws Exception {
		List<Movimiento> movimientos = new ArrayList<>();
		try {

		} catch (Exception e) {
			logger.error("Error en consultarMovimiento ==> " + e.getMessage());
			throw e;
		}
		return movimientos;
	}

}
