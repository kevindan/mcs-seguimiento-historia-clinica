package pe.sld.inen.back.seguimiento.hc.bean.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenericResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String codigo;
	private String mensaje;
	private Object data;

}
