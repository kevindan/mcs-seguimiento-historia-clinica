package pe.sld.inen.back.seguimiento.hc.util;

public enum Mensaje {
	
	CONSULTA_EXITOSA("Consulta exitosa"), 
	SIN_RESULTADO("No se encontraron registros"), 
	ERROR_GENERICO("Error Generico"), 
	ERROR_BD("Error en base de datos"), 
	REGISTRO_EXITOSO("Registro exitoso"),
	EVALUACION_PENDIENTE("Existe una evaluacion pendiente. Debe finalizar la evaluación, para aperturar una nueva."),
	RESTABLECER_CONTRASENIA("Contraseña reestablecida con éxito"),
	MODIFICAR_CONTRASENIA("Contraseña modicada con éxito"),
	OPCION_INVALIDA("response.setCodigo(codigo);\n" + 
			"				response.setMensaje(MensajeOpción inválida"),
	ACTUALIZACION_EXITOSO("Actualizacion exitosa"),
	
	// Mensaje del token:
	USUARIO_INHABILITADO("Usuario no habilitado"),
	CREDENCIALES_INVALIDAS("Credenciales invalidas"),
	JWT_EXPIRADO("JWT Token ha expirado"),
	USUARIO_NO_ENCONTRADO("Usuario no encontrado o esta dado de baja."),
	USUARIO_DISA_DUPLICADA("El usuario ya esta registrado en la disa seleccionada."),
	
	USUARIO_REGISTRADO("El usuario ya se encuentra registrado en otra Dependencia."),
	
	// Valudacion de usuario seguridad
	USUARIO_SEGURIDAD_NO_EXISTE("El Usuario no existe."),
	USUARIO_SEGURIDAD_CONTRASENIA("No es la contraseña actual."),
	USUARIO_ACTUALIZADO_BAJA("Usuario actualizado de baja."),
	USUARIO_ACTUALIZADO_ACTIVO("Usuario actualizado activo."),
	USUARIO_MENSAJE_VIGENCIA("El usuario superó la fecha de vigencia."),
	USUARIO_MENSAJE_FECHA_ACTUAL_VIGENCIA("La fecha de vigencia no puede ser menor que la fecha actual."),
	
	USUARIO_NO_PERMITIDO("Usuario no permitido"),
	DOCUMENTO_NO_REGISTRADO("Documento no registrado"),
	;
	
	private String mensaje;
	
	private Mensaje(String mensaje) {
		this.mensaje = mensaje;
		
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
}
