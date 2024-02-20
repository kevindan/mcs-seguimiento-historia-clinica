package pe.sld.inen.back.seguimiento.hc.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movimiento implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id_locacion;
    private String locacion_desc;
    private Integer id_empleado;
    private String  empleado_desc;
    private String  fecha;
    private String  hora;
    private Integer id_motivo;
    private String  motivo_desc;
    private String observacion;
    private Integer id_medico_solicitante;
    private String medico_solicitante;
    private Integer id_servicio;
    private String servicio_desc;
    private Integer id_departamento;
    private String departamento_desc;

}
