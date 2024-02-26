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
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import pe.sld.inen.back.seguimiento.hc.model.Departamento;
import pe.sld.inen.back.seguimiento.hc.service.DepartamentoService;

@RestController
@RequestMapping("/servicio/maestros")
@Api(value = "maestros", description = "Interfaz para el listado de maestros")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class MaestrosController {

	@Autowired
	private DepartamentoService departamentoService;
	
	@GetMapping(value = "/getDepartamentos", produces = "application/json")
	@RolesAllowed("backend-admin")
	public ResponseEntity<?> getMaestros() throws Exception {
		List<Departamento> lstDepartamento = new ArrayList<>();
		lstDepartamento = departamentoService.getDepartamentos();
		Map<String, Object> resp = new HashMap<>();
		resp.put("codigo", "200");
		resp.put("data", lstDepartamento);
		return ResponseEntity.ok(resp);
	}
	
}
