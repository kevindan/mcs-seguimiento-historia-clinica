package pe.sld.inen.back.seguimiento.hc.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Locacion implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer id_locacion;
	private String locacion;

}
