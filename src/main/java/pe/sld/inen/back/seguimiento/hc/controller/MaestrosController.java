package pe.sld.inen.back.seguimiento.hc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import pe.sld.inen.back.seguimiento.hc.model.Departamento;
import pe.sld.inen.back.seguimiento.hc.model.Medico;
import pe.sld.inen.back.seguimiento.hc.model.Motivo;
import pe.sld.inen.back.seguimiento.hc.model.Personal;
import pe.sld.inen.back.seguimiento.hc.model.Servicio;
import pe.sld.inen.back.seguimiento.hc.service.DepartamentoService;
import pe.sld.inen.back.seguimiento.hc.service.MedicoService;
import pe.sld.inen.back.seguimiento.hc.service.MotivoService;
import pe.sld.inen.back.seguimiento.hc.service.PersonalService;
import pe.sld.inen.back.seguimiento.hc.service.ServicioService;

@RestController
@RequestMapping("/servicio/maestros")
@Api(value = "maestros", description = "Interfaz para el listado de maestros")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class MaestrosController {

	@Autowired
	private DepartamentoService departamentoService;

	@Autowired
	private ServicioService servicioService;
	
	@Autowired
	private MotivoService motivoService;
	
	@Autowired
	private MedicoService medicoService;
	
	@Autowired
	private PersonalService personalService;
	
	@GetMapping(value = "/getDepartamentos", produces = "application/json")
	@RolesAllowed("backend-admin")
	public ResponseEntity<?> getDepartamentos() throws Exception {
		List<Departamento> lstDepartamento = new ArrayList<>();
		lstDepartamento = departamentoService.getDepartamentos();
		Map<String, Object> resp = new HashMap<>();
		resp.put("codigo", "200");
		resp.put("data", lstDepartamento);
		return ResponseEntity.ok(resp);
	}
	
	@GetMapping(value = "/getServicios", produces = "application/json")
	@RolesAllowed("backend-admin")
	public ResponseEntity<?> getServicios() throws Exception {
		List<Servicio> lstServicios = new ArrayList<>();
		lstServicios = servicioService.getServicios();
		Map<String, Object> resp = new HashMap<>();
		resp.put("codigo", "200");
		resp.put("data", lstServicios);
		return ResponseEntity.ok(resp);
	}
	
	@GetMapping(value = "/getMotivos", produces = "application/json")
	@RolesAllowed("backend-admin")
	public ResponseEntity<?> getMotivos() throws Exception {
		List<Motivo> lstMotivo = new ArrayList<>();
		lstMotivo = motivoService.getMotivos();
		Map<String, Object> resp = new HashMap<>();
		resp.put("codigo", "200");
		resp.put("data", lstMotivo);
		return ResponseEntity.ok(resp);
	}
	
	@GetMapping(value = "/getMedicosPorNombres", produces = "application/json")
	@RolesAllowed("backend-admin")
	public ResponseEntity<?> getMedicosPorNombres(@RequestParam String nombres) throws Exception {
		List<Medico> lstMedicos = new ArrayList<>();
		lstMedicos = medicoService.getMedicosPorNombres(nombres);
		Map<String, Object> resp = new HashMap<>();
		resp.put("codigo", "200");
		resp.put("data", lstMedicos);
		return ResponseEntity.ok(resp);
	}
	
	@GetMapping(value = "/getMedicoPorId", produces = "application/json")
	@RolesAllowed("backend-admin")
	public ResponseEntity<?> getMedicosPorId(@RequestParam String idMedico) throws Exception {
		Medico medico = null;
		medico = medicoService.getMedicoPorId(idMedico);
		Map<String, Object> resp = new HashMap<>();
		resp.put("codigo", "200");
		resp.put("data", medico);
		return ResponseEntity.ok(resp);
	}
	
	@GetMapping(value = "/getPersonalPorNombres", produces = "application/json")
	@RolesAllowed("backend-admin")
	public ResponseEntity<?> getPersonalPorNombres(@RequestParam String nombres) throws Exception {
		List<Personal> lstPersonal = new ArrayList<>();
		lstPersonal = personalService.getPersonalPorNombres(nombres);
		Map<String, Object> resp = new HashMap<>();
		resp.put("codigo", "200");
		resp.put("data", lstPersonal);
		return ResponseEntity.ok(resp);
	}
	
	@GetMapping(value = "/getPersonalPorId", produces = "application/json")
	@RolesAllowed("backend-admin")
	public ResponseEntity<?> getPersonalPorId(@RequestParam String idPersonal) throws Exception {
		Personal personal = null;
		personal = personalService.getPersonalPorId(idPersonal);
		Map<String, Object> resp = new HashMap<>();
		resp.put("codigo", "200");
		resp.put("data", personal);
		return ResponseEntity.ok(resp);
	}
	
}
