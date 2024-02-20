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
				.withCatalogName("PKG_SEGUIMIENTO_HISTORIA_CLINICA")
				.withoutProcedureColumnMetaDataAccess()
				.declareParameters(
						new SqlParameter("p_ncodigo_servicio", Types.INTEGER),						
						new SqlOutParameter("p_vcodigo", Types.VARCHAR),
						new SqlOutParameter("p_cdepartamentos", OracleTypes.CURSOR, new DepartamentoRowMapper()));
						
	}

	@Override
	public List<Departamento> getDepartamentos(Integer idServicio) throws SQLException, Exception  {
		List<Departamento> lstDepartamentos = new ArrayList<Departamento>();
		Map<String, Object> inParam = new HashMap<>();
		inParam.put("p_ncodigo_servicio", idServicio);
		try {
			Map<String, Object> out = listarDepartamentos.execute(inParam);
			String codigo = (String) out.get("p_vcodigo");			
			if(codigo.equals("0000")) {
				lstDepartamentos = (List<Departamento>) out.get("p_cdepartamentos");
			}			
		}catch (Exception e) {
			logger.error("Error getDepartamentos ==> "+e.getMessage());
			throw e;
		}
		return lstDepartamentos;	
	}

}
