package pe.sld.inen.back.seguimiento.hc.bean.request;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrarEntregaRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private String codigo_barra;
	private String numero_historia_clinica;
	private Integer id_paciente;
	private Integer id_locacion_origen;
	private Integer id_locacion_destino;
	private Integer id_empleado_origen;
	private Integer id_empleado_destino;
	private String fecha;
	private String hora;
	private Integer id_estado;
	private Integer id_motivo;
	private String observacion;
	private Integer id_medico_solicitante;
	private Integer id_servicio;
	private Integer id_departamento;

}
