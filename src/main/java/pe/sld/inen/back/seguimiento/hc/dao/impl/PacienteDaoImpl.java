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
import pe.sld.inen.back.seguimiento.hc.dao.PacienteDao;
import pe.sld.inen.back.seguimiento.hc.dao.ServicioDao;
import pe.sld.inen.back.seguimiento.hc.model.Paciente;
import pe.sld.inen.back.seguimiento.hc.model.Servicio;
import pe.sld.inen.back.seguimiento.hc.rowmapper.ServicioRowMapper;

@Repository
public class PacienteDaoImpl extends JdbcDaoSupport implements PacienteDao {

	private final SimpleJdbcCall listarPacientesPorDni;
	
	public PacienteDaoImpl(DataSource dataSource) {
		this.setDataSource(dataSource);
		this.listarPacientesPorDni = new SimpleJdbcCall(this.getJdbcTemplate())
				.withProcedureName("SP_LISTAR_PACIENTES_DNI")
				.withCatalogName("PKG_SEGUIMIENTO_HISTORIA_CLINICA")
				.withoutProcedureColumnMetaDataAccess()
				.declareParameters(
						new SqlParameter("p_vdni", Types.VARCHAR),
						new SqlOutParameter("p_vcodigo", Types.VARCHAR),
						new SqlOutParameter("p_cpacientes", OracleTypes.CURSOR, new ServicioRowMapper()));
						
	}

	@Override
	public List<Paciente> getPacientesPorDni(String dni) throws SQLException, Exception {
		List<Paciente> lstPacientes = new ArrayList<Paciente>();		
		try {
			Map<String, Object> out = listarPacientesPorDni.execute();
			String codigo = (String) out.get("p_vcodigo");			
			if(codigo.equals("0000")) {
				lstPacientes = (List<Paciente>) out.get("p_cpacientes");
			}			
		}catch (Exception e) {
			logger.error("Error getPacientesPorDni ==> "+e.getMessage());
			throw e;
		}
		return lstPacientes;	
	}

}
