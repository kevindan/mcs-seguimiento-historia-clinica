package pe.sld.inen.back.seguimiento.hc.dao.impl;

import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlOutParameter;
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

	private final SimpleJdbcCall listarMedicos;
	
	public MedicoDaoImpl(DataSource dataSource) {
		this.setDataSource(dataSource);
		this.listarMedicos = new SimpleJdbcCall(this.getJdbcTemplate())
				.withProcedureName("SP_LISTAR_MEDICOS")
				.withCatalogName("PKG_SEGUIMIENTO_HISTORIA_CLINICA")
				.withoutProcedureColumnMetaDataAccess()
				.declareParameters(				
						new SqlOutParameter("p_vcodigo", Types.VARCHAR),
						new SqlOutParameter("p_cmedicos", OracleTypes.CURSOR, new MedicoRowMapper()));
						
	}

	@Override
	public List<Medico> getMedicos() throws SQLException, Exception {
		List<Medico> lstMedicos = new ArrayList<Medico>();		
		try {
			Map<String, Object> out = listarMedicos.execute();
			String codigo = (String) out.get("p_vcodigo");			
			if(codigo.equals("0000")) {
				lstMedicos = (List<Medico>) out.get("p_cmedico");
			}			
		}catch (Exception e) {
			logger.error("Error getMedicos ==> "+e.getMessage());
			throw e;
		}
		return lstMedicos;	
	}

}
