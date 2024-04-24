package pe.sld.inen.back.seguimiento.hc.dao.impl;

import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import oracle.jdbc.OracleTypes;
import pe.sld.inen.back.seguimiento.hc.dao.MedicoDao;
import pe.sld.inen.back.seguimiento.hc.dao.ServicioDao;
import pe.sld.inen.back.seguimiento.hc.model.Medico;
import pe.sld.inen.back.seguimiento.hc.model.Servicio;
import pe.sld.inen.back.seguimiento.hc.rowmapper.MedicoRowMapper;
import pe.sld.inen.back.seguimiento.hc.rowmapper.ServicioRowMapper;

@Repository
public class MedicoDaoImpl extends JdbcDaoSupport implements MedicoDao {

	private final SimpleJdbcCall listarMedicosPorNombre;
	private final SimpleJdbcCall buscarMedicoPorId;
	
	public MedicoDaoImpl(DataSource dataSource) {
		this.setDataSource(dataSource);
		this.listarMedicosPorNombre = new SimpleJdbcCall(this.getJdbcTemplate())
				.withProcedureName("SP_LISTAR_MEDICOS_POR_NOMBRES")
				.withCatalogName("INEN.PKG_SEGUIMIENTO_HISTORIA_CLINICA")
				.withoutProcedureColumnMetaDataAccess()
				.declareParameters(				
						new SqlParameter("nombres", Types.VARCHAR),
						new SqlOutParameter("medicos", OracleTypes.CURSOR, new MedicoRowMapper()));

		this.buscarMedicoPorId = new SimpleJdbcCall(this.getJdbcTemplate())
				.withProcedureName("SP_BUSCAR_MEDICO_POR_ID")
				.withCatalogName("INEN.PKG_SEGUIMIENTO_HISTORIA_CLINICA")
				.withoutProcedureColumnMetaDataAccess()
				.declareParameters(				
						new SqlParameter("idmedico", Types.VARCHAR),
						new SqlOutParameter("medicos", OracleTypes.CURSOR, new MedicoRowMapper()));
		
	}

	@Override
	public List<Medico> getMedicosPorNombres(String nombres) throws SQLException, Exception {
		List<Medico> lstMedicos = new ArrayList<Medico>();
		Map<String, Object> inParam = new HashMap<>();
		inParam.put("nombres", nombres);
		try {
			Map<String, Object> out = listarMedicosPorNombre.execute(inParam);
			lstMedicos = (List<Medico>) out.get("medicos");
		}catch (Exception e) {
			logger.error("Error getMedicosPorNombres ==> "+e.getMessage());
			throw e;
		}
		return lstMedicos;	
	}

	@Override
	public Medico getMedicoPorId(String idMedico) throws SQLException, Exception {
		List<Medico> lstMedicos = new ArrayList<Medico>();
		Medico medico = null;
		Map<String, Object> inParam = new HashMap<>();
		inParam.put("idmedico", idMedico);
		try {
			Map<String, Object> out = buscarMedicoPorId.execute(inParam);
			lstMedicos = (List<Medico>) out.get("medicos");			
			if(!(lstMedicos.isEmpty())) {
				medico = lstMedicos.get(0);
			}
		}catch (Exception e) {
			logger.error("Error getMedicoPorId ==> "+e.getMessage());
			throw e;
		}
		return medico;	
	}

}
