package pe.sld.inen.back.seguimiento.hc.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.security.RolesAllowed;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/servicio/v1.0")
@Api(value = "consultatrabajador", description = "Interfaz para la consulta del trabajador del hogar")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
public class ConsultaTrabajadorController {

	
	@GetMapping(value = "/test", produces = "application/json")
	@RolesAllowed("backend-admin")
	public ResponseEntity<?> test() {
		Map<String, Object> resp = new HashMap<>();
		resp.put("codigo", "200");
		resp.put("mensaje", "Autenticado con exito");
		return ResponseEntity.ok(resp);
	}
	
}
