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
import pe.sld.inen.back.seguimiento.hc.dao.ServicioDao;
import pe.sld.inen.back.seguimiento.hc.model.Servicio;
import pe.sld.inen.back.seguimiento.hc.rowmapper.ServicioRowMapper;

@Repository
public class ServicioDaoImpl extends JdbcDaoSupport implements ServicioDao {

	private final SimpleJdbcCall listarServicios;
	
	public ServicioDaoImpl(DataSource dataSource) {
		this.setDataSource(dataSource);
		this.listarServicios = new SimpleJdbcCall(this.getJdbcTemplate())
				.withProcedureName("SP_LISTAR_SERVICIOS")
				.withCatalogName("INEN.PKG_SEGUIMIENTO_HISTORIA_CLINICA")
				.withoutProcedureColumnMetaDataAccess()
				.declareParameters(
						new SqlOutParameter("servicios", OracleTypes.CURSOR, new ServicioRowMapper()));
						
	}

	@Override
	public List<Servicio> getServicios() throws SQLException, Exception{
		List<Servicio> lstDepartamentos = new ArrayList<Servicio>();		
		try {
			Map<String, Object> out = listarServicios.execute();
			
				lstDepartamentos = (List<Servicio>) out.get("servicios");
			
		}catch (Exception e) {
			logger.error("Error getServicios ==> "+e.getMessage());
			throw e;
		}
		return lstDepartamentos;	
	}

}
