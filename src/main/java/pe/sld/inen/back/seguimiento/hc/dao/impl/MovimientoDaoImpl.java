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
import pe.sld.inen.back.seguimiento.hc.bean.request.RegistrarEntregaRequest;
import pe.sld.inen.back.seguimiento.hc.bean.response.GenericResponse;
import pe.sld.inen.back.seguimiento.hc.dao.MovimientoDao;
import pe.sld.inen.back.seguimiento.hc.model.Movimiento;
import pe.sld.inen.back.seguimiento.hc.rowmapper.MovimientoRowMapper;

@Repository
public class MovimientoDaoImpl extends JdbcDaoSupport implements MovimientoDao {

	private final SimpleJdbcCall registroMovimiento;
	private final SimpleJdbcCall consultaMovimientos;
	
	public MovimientoDaoImpl(DataSource dataSource) {
		this.setDataSource(dataSource);
		this.registroMovimiento = new SimpleJdbcCall(this.getJdbcTemplate())
				.withProcedureName("SP_REGISTRAR_MOVIMIENTO")
				.withCatalogName("PKG_SEGUIMIENTO_HISTORIA_CLINICA")
				.withoutProcedureColumnMetaDataAccess()
				.declareParameters(
						new SqlParameter("p_vhora", Types.VARCHAR),
						new SqlParameter("p_vfecha", Types.VARCHAR),
						new SqlParameter("p_nid_estado", Types.INTEGER),
						new SqlParameter("p_nid_motivo", Types.INTEGER),
						new SqlParameter("p_nid_paciente", Types.INTEGER),
						new SqlParameter("p_nid_servicio", Types.INTEGER),
						new SqlParameter("p_vobservacion", Types.VARCHAR),
						new SqlParameter("p_vcodigo_barra", Types.VARCHAR),
						new SqlParameter("p_nid_departamento", Types.INTEGER),
						new SqlParameter("p_nid_empleado_origen", Types.INTEGER),
						new SqlParameter("p_nid_locacion_origen", Types.INTEGER),
						new SqlParameter("p_nid_empleado_destino", Types.INTEGER),
						new SqlParameter("p_nid_locacion_destino", Types.INTEGER),
						new SqlParameter("p_nid_medico_solicitante", Types.INTEGER),
						new SqlParameter("p_vnumero_historia_clinica", Types.VARCHAR),
						new SqlOutParameter("p_vcodigo", Types.VARCHAR));
		
		this.consultaMovimientos = new SimpleJdbcCall(this.getJdbcTemplate())
				.withProcedureName("SP_CONSULTA_MOVIMIENTOS")
				.withCatalogName("PKG_SEGUIMIENTO_HISTORIA_CLINICA")
				.withoutProcedureColumnMetaDataAccess()
				.declareParameters(
						new SqlParameter("p_vnumero_historia_clinica", Types.VARCHAR),						
						new SqlOutParameter("p_vcodigo", Types.VARCHAR),
						new SqlOutParameter("p_cmovimientos", OracleTypes.CURSOR, new MovimientoRowMapper()));
						
	}
	
	@Override
	public GenericResponse registraEntrega(RegistrarEntregaRequest registrarEntregaRequest) throws SQLException, Exception {
		GenericResponse response = new GenericResponse();
		Map<String, Object> inParam = new HashMap<>();
		inParam.put("p_vhora", registrarEntregaRequest.getHora());
		inParam.put("p_vfecha", registrarEntregaRequest.getFecha());
		inParam.put("p_nid_estado", registrarEntregaRequest.getId_estado());
		inParam.put("p_nid_motivo", registrarEntregaRequest.getId_motivo());
		inParam.put("p_nid_paciente", registrarEntregaRequest.getId_paciente());
		inParam.put("p_nid_servicio", registrarEntregaRequest.getId_servicio());
		inParam.put("p_vobservacion", registrarEntregaRequest.getObservacion());
		inParam.put("p_vcodigo_barra", registrarEntregaRequest.getCodigo_barra());
		inParam.put("p_nid_departamento", registrarEntregaRequest.getId_departamento());
		inParam.put("p_nid_empleado_origen", registrarEntregaRequest.getId_empleado_origen());
		inParam.put("p_nid_locacion_origen", registrarEntregaRequest.getId_locacion_origen());
		inParam.put("p_nid_empleado_destino", registrarEntregaRequest.getId_empleado_destino());
		inParam.put("p_nid_locacion_destino", registrarEntregaRequest.getId_locacion_destino());
		inParam.put("p_nid_medico_solicitante", registrarEntregaRequest.getId_medico_solicitante());
		inParam.put("p_vnumero_historia_clinica", registrarEntregaRequest.getNumero_historia_clinica());
		try {
			Map<String, Object> out = registroMovimiento.execute(inParam);
			String codigo = (String) out.get("p_vcodigo");
			String mensaje = null;
			if(codigo.equals("0000")) {
				mensaje="Registro satisfactorio";
			}else {
				mensaje="El la HC ya ha sido registrado en esta locación";
			}
			response.setCodigo(codigo);
			response.setData(mensaje);
		}catch (Exception e) {
			logger.error("Error registrarEntrega ==> "+e.getMessage());
			throw e;
		}
		return response ;
	}

	@Override
	public List<Movimiento> consultarMovimiento(String numeroHistoriaClinica) throws SQLException, Exception{
		List<Movimiento> lstMovimientos = new ArrayList<Movimiento>();
		Map<String, Object> inParam = new HashMap<>();
		inParam.put("p_vnumero_historia_clinica", numeroHistoriaClinica);
		try {
			Map<String, Object> out = consultaMovimientos.execute(inParam);
			String codigo = (String) out.get("p_vcodigo");			
			if(codigo.equals("0000")) {
				lstMovimientos = (List<Movimiento>) out.get("p_cmovimientos");
			}			
		}catch (Exception e) {
			logger.error("Error registrarEntrega ==> "+e.getMessage());
			throw e;
		}
		return lstMovimientos;
	}

}
