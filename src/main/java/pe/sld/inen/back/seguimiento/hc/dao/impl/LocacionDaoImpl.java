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
import pe.sld.inen.back.seguimiento.hc.dao.LocacionDao;
import pe.sld.inen.back.seguimiento.hc.dao.ServicioDao;
import pe.sld.inen.back.seguimiento.hc.model.Locacion;
import pe.sld.inen.back.seguimiento.hc.model.Servicio;
import pe.sld.inen.back.seguimiento.hc.rowmapper.LocacionRowMapper;
import pe.sld.inen.back.seguimiento.hc.rowmapper.ServicioRowMapper;

@Repository
public class LocacionDaoImpl extends JdbcDaoSupport implements LocacionDao {

	private final SimpleJdbcCall listarLocaciones;
	
	public LocacionDaoImpl(DataSource dataSource) {
		this.setDataSource(dataSource);
		this.listarLocaciones = new SimpleJdbcCall(this.getJdbcTemplate())
				.withProcedureName("SP_LISTAR_LOCACIONES")
				.withCatalogName("PKG_SEGUIMIENTO_HISTORIA_CLINICA")
				.withoutProcedureColumnMetaDataAccess()
				.declareParameters(				
						new SqlOutParameter("p_vcodigo", Types.VARCHAR),
						new SqlOutParameter("p_clocaciones", OracleTypes.CURSOR, new LocacionRowMapper()));
						
	}


	@Override
	public List<Locacion> getLocaciones() throws SQLException, Exception {
		List<Locacion> lstLocaciones = new ArrayList<Locacion>();		
		try {
			Map<String, Object> out = listarLocaciones.execute();
			String codigo = (String) out.get("p_vcodigo");			
			if(codigo.equals("0000")) {
				lstLocaciones = (List<Locacion>) out.get("p_clocaciones");
			}			
		}catch (Exception e) {
			logger.error("Error getLocaciones ==> "+e.getMessage());
			throw e;
		}
		return lstLocaciones;
	}

}
