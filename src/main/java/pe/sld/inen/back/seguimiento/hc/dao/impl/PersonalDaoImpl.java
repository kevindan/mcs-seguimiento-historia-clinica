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
import pe.sld.inen.back.seguimiento.hc.dao.PersonalDao;
import pe.sld.inen.back.seguimiento.hc.model.Personal;
import pe.sld.inen.back.seguimiento.hc.rowmapper.PersonalRowMapper;

@Repository
public class PersonalDaoImpl extends JdbcDaoSupport implements PersonalDao {
	
	private final SimpleJdbcCall listarPersonalPorNombre;
	private final SimpleJdbcCall buscarPersonalPorId;
		
	public PersonalDaoImpl(DataSource datasource) {
		this.setDataSource(datasource);
		this.listarPersonalPorNombre = new SimpleJdbcCall(this.getJdbcTemplate())
				.withProcedureName("SP_LISTAR_PERSONAL_POR_NOMBRES")
				.withCatalogName("INEN.PKG_SEGUIMIENTO_HISTORIA_CLINICA")
				.withoutProcedureColumnMetaDataAccess()
				.declareParameters(				
						new SqlParameter("nombres", Types.VARCHAR),
						new SqlOutParameter("personal", OracleTypes.CURSOR, new PersonalRowMapper()));

		this.buscarPersonalPorId = new SimpleJdbcCall(this.getJdbcTemplate())
				.withProcedureName("SP_BUSCAR_PERSONAL_POR_ID")
				.withCatalogName("INEN.PKG_SEGUIMIENTO_HISTORIA_CLINICA")
				.withoutProcedureColumnMetaDataAccess()
				.declareParameters(				
						new SqlParameter("idpersonal", Types.VARCHAR),
						new SqlOutParameter("personal", OracleTypes.CURSOR, new PersonalRowMapper()));		
	}
	

	@Override
	public List<Personal> getPersonalPorNombres(String nombres) throws SQLException, Exception {
		List<Personal> lstPersonal = new ArrayList<Personal>();
		Map<String, Object> inParam = new HashMap<>();
		inParam.put("nombres", nombres);
		try {
			Map<String, Object> out = listarPersonalPorNombre.execute(inParam);
			lstPersonal = (List<Personal>) out.get("personal");
		}catch (Exception e) {
			logger.error("Error getPersonalPorNombres ==> "+e.getMessage());
			throw e;
		}
		return lstPersonal;	
	}

	@Override
	public Personal getPersonalPorId(String idPersonal) throws SQLException, Exception {
		List<Personal> lstPersonal = new ArrayList<Personal>();
		Personal personal = null;
		Map<String, Object> inParam = new HashMap<>();
		inParam.put("idpersonal", idPersonal);
		try {
			Map<String, Object> out = buscarPersonalPorId.execute(inParam);
			lstPersonal= (List<Personal>) out.get("personal");			
			if(!(lstPersonal.isEmpty())) {
				personal = lstPersonal.get(0);
			}
		}catch (Exception e) {
			logger.error("Error getPersonalPorId ==> "+e.getMessage());
			throw e;
		}
		return personal;
	}

}
