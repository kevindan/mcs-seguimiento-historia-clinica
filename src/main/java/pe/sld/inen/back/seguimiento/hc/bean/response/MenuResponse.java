package pe.sld.inen.back.seguimiento.hc.bean.response;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.sld.inen.back.seguimiento.hc.model.Menu;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Menu> defaultMenu;
	
}
