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
import pe.sld.inen.back.seguimiento.hc.dao.DepartamentoDao;
import pe.sld.inen.back.seguimiento.hc.model.Departamento;
import pe.sld.inen.back.seguimiento.hc.rowmapper.DepartamentoRowMapper;


@Repository
public class DepartamentoDaoImpl extends JdbcDaoSupport implements DepartamentoDao {

	private final SimpleJdbcCall listarDepartamentos;
	
	public DepartamentoDaoImpl(DataSource dataSource) {
		this.setDataSource(dataSource);
		this.listarDepartamentos = new SimpleJdbcCall(this.getJdbcTemplate())
				.withProcedureName("SP_LISTAR_DEPARTAMENTOS")
				.withCatalogName("INEN.PKG_SEGUIMIENTO_HISTORIA_CLINICA")
				.withoutProcedureColumnMetaDataAccess()
				.declareParameters(			
						new SqlOutParameter("departamentos", OracleTypes.CURSOR, new DepartamentoRowMapper()));
						
	}

	@Override
	public List<Departamento> getDepartamentos() throws SQLException, Exception  {
		List<Departamento> lstDepartamentos = new ArrayList<Departamento>();		
		try {
			Map<String, Object> out = listarDepartamentos.execute();		
			lstDepartamentos = (List<Departamento>) out.get("departamentos");					
		}catch (Exception e) {
			logger.error("Error getDepartamentos ==> "+e.getMessage());
			throw e;
		}
		return lstDepartamentos;	
	}

}
