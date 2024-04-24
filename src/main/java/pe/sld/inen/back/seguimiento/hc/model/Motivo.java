package pe.sld.inen.back.seguimiento.hc.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Motivo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id_motivo;
	private String motivo;
	

}
