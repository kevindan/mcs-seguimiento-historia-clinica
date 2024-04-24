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
import pe.sld.inen.back.seguimiento.hc.dao.MotivoDao;
import pe.sld.inen.back.seguimiento.hc.model.Motivo;
import pe.sld.inen.back.seguimiento.hc.rowmapper.MotivoRowMapper;

@Repository
public class MotivoDaoImpl extends JdbcDaoSupport implements MotivoDao {

	private final SimpleJdbcCall listarMotivos;
	
	public MotivoDaoImpl(DataSource dataSource) {
		this.setDataSource(dataSource);
		this.listarMotivos = new SimpleJdbcCall(this.getJdbcTemplate())
				.withProcedureName("SP_LISTAR_MOTIVOS")
				.withCatalogName("INEN.PKG_SEGUIMIENTO_HISTORIA_CLINICA")
				.withoutProcedureColumnMetaDataAccess()
				.declareParameters(
						new SqlOutParameter("motivos", OracleTypes.CURSOR, new MotivoRowMapper()));
	}

	@Override
	public List<Motivo> getMotivos() throws SQLException, Exception{
		List<Motivo> lstMotivos = new ArrayList<Motivo>();				
		try {
			Map<String, Object> out = listarMotivos.execute();
			lstMotivos = (List<Motivo>) out.get("motivos");		
		}catch (Exception e) {
			logger.error("Error getMotivos ==> "+e.getMessage());
			throw e;
		}
		return lstMotivos;	
	}

}
