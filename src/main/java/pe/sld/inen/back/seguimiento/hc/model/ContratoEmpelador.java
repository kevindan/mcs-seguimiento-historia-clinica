package pe.sld.inen.back.seguimiento.hc.model;

import java.io.Serializable;

public class ContratoEmpelador implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String tipoDocumento;
	private String numeroDocumento;
	private String telefono;
	private String correo;
	private String domicilio;
	private String ubigeo;
	private String codigoContrato;
	private String codigoEmpleador;
	private String numeroContrato;
	private String fechaInicio;
	private String fechaFin;
	private String estadoContrato;
	private String direccionContrato;
	private String codigoDepartamento;
	private String codigoProvincia;
	private String codigoDistrito;
	private String telefonoTrabajo;
	private String fechaRegistroContrato;
	private String fechaModificacionContrato;
	private String fechaBaja;
	private String fechaRegistroBaja;
	private String motivobaja;

	public ContratoEmpelador() {

	}

	public ContratoEmpelador(String nombre, String apellidoPaterno, String apellidoMaterno, String tipoDocumento,
			String numeroDocumento, String telefono, String correo, String domicilio, String ubigeo,
			String codigoContrato, String codigoEmpleador, String numeroContrato, String fechaInicio, String fechaFin,
			String estadoContrato, String direccionContrato, String codigoDepartamento, String codigoProvincia,
			String codigoDistrito, String telefonoTrabajo, String fechaRegistroContrato,
			String fechaModificacionContrato, String fechaBaja, String fechaRegistroBaja, String motivobaja) {

		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.telefono = telefono;
		this.correo = correo;
		this.domicilio = domicilio;
		this.ubigeo = ubigeo;
		this.codigoContrato = codigoContrato;
		this.codigoEmpleador = codigoEmpleador;
		this.numeroContrato = numeroContrato;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.estadoContrato = estadoContrato;
		this.direccionContrato = direccionContrato;
		this.codigoDepartamento = codigoDepartamento;
		this.codigoProvincia = codigoProvincia;
		this.codigoDistrito = codigoDistrito;
		this.telefonoTrabajo = telefonoTrabajo;
		this.fechaRegistroContrato = fechaRegistroContrato;
		this.fechaModificacionContrato = fechaModificacionContrato;
		this.fechaBaja = fechaBaja;
		this.fechaRegistroBaja = fechaRegistroBaja;
		this.motivobaja = motivobaja;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getUbigeo() {
		return ubigeo;
	}

	public void setUbigeo(String ubigeo) {
		this.ubigeo = ubigeo;
	}

	public String getCodigoContrato() {
		return codigoContrato;
	}

	public void setCodigoContrato(String codigoContrato) {
		this.codigoContrato = codigoContrato;
	}

	public String getCodigoEmpleador() {
		return codigoEmpleador;
	}

	public void setCodigoEmpleador(String codigoEmpleador) {
		this.codigoEmpleador = codigoEmpleador;
	}

	public String getNumeroContrato() {
		return numeroContrato;
	}

	public void setNumeroContrato(String numeroContrato) {
		this.numeroContrato = numeroContrato;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getEstadoContrato() {
		return estadoContrato;
	}

	public void setEstadoContrato(String estadoContrato) {
		this.estadoContrato = estadoContrato;
	}

	public String getDireccionContrato() {
		return direccionContrato;
	}

	public void setDireccionContrato(String direccionContrato) {
		this.direccionContrato = direccionContrato;
	}

	public String getCodigoDepartamento() {
		return codigoDepartamento;
	}

	public void setCodigoDepartamento(String codigoDepartamento) {
		this.codigoDepartamento = codigoDepartamento;
	}

	public String getCodigoProvincia() {
		return codigoProvincia;
	}

	public void setCodigoProvincia(String codigoProvincia) {
		this.codigoProvincia = codigoProvincia;
	}

	public String getCodigoDistrito() {
		return codigoDistrito;
	}

	public void setCodigoDistrito(String codigoDistrito) {
		this.codigoDistrito = codigoDistrito;
	}

	public String getTelefonoTrabajo() {
		return telefonoTrabajo;
	}

	public void setTelefonoTrabajo(String telefonoTrabajo) {
		this.telefonoTrabajo = telefonoTrabajo;
	}

	public String getFechaRegistroContrato() {
		return fechaRegistroContrato;
	}

	public void setFechaRegistroContrato(String fechaRegistroContrato) {
		this.fechaRegistroContrato = fechaRegistroContrato;
	}

	public String getFechaModificacionContrato() {
		return fechaModificacionContrato;
	}

	public void setFechaModificacionContrato(String fechaModificacionContrato) {
		this.fechaModificacionContrato = fechaModificacionContrato;
	}

	public String getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(String fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public String getFechaRegistroBaja() {
		return fechaRegistroBaja;
	}

	public void setFechaRegistroBaja(String fechaRegistroBaja) {
		this.fechaRegistroBaja = fechaRegistroBaja;
	}

	public String getMotivobaja() {
		return motivobaja;
	}

	public void setMotivobaja(String motivobaja) {
		this.motivobaja = motivobaja;
	}

	@Override
	public String toString() {
		return "ContratoEmpelador [nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno="
				+ apellidoMaterno + ", tipoDocumento=" + tipoDocumento + ", numeroDocumento=" + numeroDocumento
				+ ", telefono=" + telefono + ", correo=" + correo + ", domicilio=" + domicilio + ", ubigeo=" + ubigeo
				+ ", codigoContrato=" + codigoContrato + ", codigoEmpleador=" + codigoEmpleador + ", numeroContrato="
				+ numeroContrato + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", estadoContrato="
				+ estadoContrato + ", direccionContrato=" + direccionContrato + ", codigoDepartamento="
				+ codigoDepartamento + ", codigoProvincia=" + codigoProvincia + ", codigoDistrito=" + codigoDistrito
				+ ", telefonoTrabajo=" + telefonoTrabajo + ", fechaRegistroContrato=" + fechaRegistroContrato
				+ ", fechaModificacionContrato=" + fechaModificacionContrato + ", fechaBaja=" + fechaBaja
				+ ", fechaRegistroBaja=" + fechaRegistroBaja + ", motivobaja=" + motivobaja + "]";
	}

}
